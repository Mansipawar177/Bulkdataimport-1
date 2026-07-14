package com.example.demo.dto;
import lombok.Data;
import java.util.List;
@Data
public class ImportSummary {
private Long jobId;
private String fileName;
private String Status;
private Integer totalRecords;
private Integer successCount;
private Integer failedCount;
private List<String> errors;
	
}
