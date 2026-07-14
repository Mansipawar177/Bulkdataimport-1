package com.example.demo.dto;
import jakarta.validation.constraints.Email;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Data
public class ImportRecordDTO {
@NotBlank(message="name is required")
private String name;
@Email(message="Invalid Email")
private String email;
@Pattern(regexp="^[0-9]{10}$",message="phone must contain 10 digits")
private String phone;
	

}
