package com.example.demo.Repository;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ImportJob;
@Repository
public interface ImportJobRepository extends JpaRepository<ImportJob,Long>{
	Optional<ImportJob>
findByFileName(String fileName);
	
}
