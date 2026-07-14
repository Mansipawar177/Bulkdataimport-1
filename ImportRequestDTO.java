package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImportRequestDTO {
@NotBlank(message="name is required")
private String name;
@Email(message="invalid email format")
@NotBlank(message="email is required")
private String email;
@Pattern(regexp="^[0-9]{10}$",message="phone number must be 10 digiits")
	private String Phone;

}
