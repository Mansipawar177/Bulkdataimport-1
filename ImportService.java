package com.example.demo.service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.dto.ImportSummary;
public interface ImportService {
ImportSummary uploadFile(MultipartFile file);
ImportSummary getJobSummary(Long jobId);
}