package com.example.demo.service;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.dto.ImportRecordDTO;
import com.example.demo.dto.ImportSummary;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import com.example.demo.entity.ImportJob;
import java.util.List;
import com.example.demo.entity.ImportRecord;
import com.example.demo.Repository.ImportJobRepository;
import com.example.demo.Repository.ImportRecordRepository;
import com.example.demo.service.ImportService; 
import com.example.demo.Util.CsvHelper;
@Service
public class ImportServiceImpl implements ImportService{
	@Autowired
	private ImportJobRepository jobRepository;
	@Autowired
	private ImportRecordRepository recordRepository;
	@Autowired
	private CsvHelper csvHelper;
	@Override
	public ImportSummary uploadFile(MultipartFile file) {
		ImportJob job=new ImportJob();
		job.setFileName(file.getOriginalFilename());
		job.setStatus("PROCESSING");
		job.setCreatedAt(LocalDateTime.now());
		job=jobRepository.save(job);
		processFile(file,job);
		ImportSummary summary =new ImportSummary();
		
		summary.setJobId(job.getId());
		summary.setFileName(job.getFileName());
		summary.setStatus(job.getStatus());
		return getJobSummary(job.getId());
	}
	@Async
	public CompletableFuture<Void>processFile(MultipartFile file,ImportJob job){
		try {
			List<ImportRecordDTO>dtoList=csvHelper.readCsv(file);
			int success=0;
			List<ImportRecord>recordList=new ArrayList<>();
			for(ImportRecordDTO dto:dtoList) {
				ImportRecord record=new ImportRecord();
				record.setName(dto.getName());
				record.setEmail(dto.getEmail());
				record.setPhone(dto.getPhone());
				record.setImportJob(job);
				if(validateRecord(dto)) {
					
					success++;
				
					record.setStatus("SUCCESS");
					record.setErrorMessage(null);
				}else {
					record.setStatus("FAILED");
					record.setErrorMessage("Invalid Record");
				}
				
				recordList.add(record);
			}
			recordRepository.saveAll(recordList);
			job.setTotalRecords(dtoList.size());
			job.setSuccessRecords(success);
			job.setStatus("COMPLETED");
			jobRepository.save(job);
		}catch(Exception e) {
			job.setStatus("FAILED");
			jobRepository.save(job);
		}
	
		
		
		
		return CompletableFuture.completedFuture(null);
	}
	private boolean validateRecord(ImportRecordDTO dto) {
		if(dto.getName()==null||dto.getName().trim().isEmpty())
			return false;
		if(dto.getEmail()==null||!dto.getEmail().contains("@"))
			return false;
		if(dto.getPhone()==null||dto.getPhone().length()!=10)
			return false;
		return true;
	}
	@Override
	public ImportSummary getJobSummary(Long jobId) {
		ImportJob job =jobRepository.findById(jobId).orElseThrow(()->new ResourceNotFoundException("job not Found"));
		
		List<ImportRecord>records=recordRepository.findByImportJob(job);
		int success=0;
		int failed=0;
		
		for(ImportRecord record :records) {
			if("SUCCESS".equalsIgnoreCase(record.getStatus())) {
				success++;
			}else {
				failed++;
			}
		}
		ImportSummary summary=new ImportSummary();
		summary.setJobId(job.getId());
		summary.setFileName(job.getFileName());
		summary.setStatus(job.getStatus());
		summary.setTotalRecords(records.size());
		summary.setSuccessCount(success);
		summary.setFailedCount(failed);
		return summary;
		
		
		
	}
}