package com.example.demo.dto;
import lombok.Data;
@Data
public class ImportResponseDTO {

	private Long jobId;
	private String FileName;
	private String status;
	private Integer totalRecords;
	private Integer successRecords;
	private Integer failedRecords;
}
