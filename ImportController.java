package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.dto.ImportSummary;
import com.example.demo.service.ImportService;
@RestController
@RequestMapping("/api/import")
public class ImportController {
	@Autowired
	private ImportService importService;
	@PostMapping("/upload")
	public ResponseEntity<ImportSummary>uploadFile(
			@RequestParam("file")MultipartFile file){
		ImportSummary response=importService.uploadFile(file);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/summary/{jobId}")
public ResponseEntity<ImportSummary>getJobSummary(
		@PathVariable Long jobId){
		ImportSummary summary=importService.getJobSummary(jobId);
		return ResponseEntity.ok(summary);
		                                     
		
	}

	

}
