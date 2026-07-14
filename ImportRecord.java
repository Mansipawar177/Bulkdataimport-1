package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
@Table(name="import_record")
@Data
@Entity
public class ImportRecord {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String email;
private String name;
private String phone;
private String status;
@Column(name="error_message")
private String errorMessage;

@ManyToOne
@JoinColumn(name="job_id")
private ImportJob importJob;
}
