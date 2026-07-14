package com.example.demo.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.dto.ImportRecordDTO;
@Component
public class CsvHelper {
public List<ImportRecordDTO> readCsv(MultipartFile file)throws IOException{
	List<ImportRecordDTO>recordList=new ArrayList<>();
	BufferedReader reader =new BufferedReader(new InputStreamReader (file.getInputStream()));
	String line;
	reader.readLine();
	while((line=reader.readLine())!=null) {
		String[]data=line.split(",");
		ImportRecordDTO dto =new ImportRecordDTO();
		dto.setName(data[0].trim());
		dto.setEmail(data[1].trim()); 
		dto.setPhone(data[2].trim());
		recordList.add(dto);
	}
	reader.close();
	return recordList;
}
public boolean isCsvFile(MultipartFile file) {
	return"text/csv".equals(file.getContentType())||file.getOriginalFilename().endsWith(".csv");
	
	}
}
	
