package com.example.demo.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String>HandlerResourceNotFound(ResourceNotFoundException ex){
	return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<String>handleValidaton(MethodArgumentNotValidException ex){
	
return new ResponseEntity("validation failed",HttpStatus.BAD_REQUEST);

}
@ExceptionHandler(Exception.class)
public ResponseEntity<String>handlerException(Exception ex){
	return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
	