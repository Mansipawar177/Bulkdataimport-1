package com.example.demo.entity;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="import_job")
public class ImportJob {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@Column(name="file_name")
private String fileName;
private String status;
@Column(name="total_records")
private Integer totalRecords;
@Column(name="successRecords") 
private Integer successRecords;
@Column(name="created_at")
private LocalDateTime createdAt;
@OneToMany(mappedBy="importJob",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<ImportRecord>records;
}
