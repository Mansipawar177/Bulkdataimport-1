package com.example.demo.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ImportJob;
import com.example.demo.entity.ImportRecord;
public interface ImportRecordRepository extends JpaRepository<ImportRecord,Long>{
	List<ImportRecord> findByStatus(String status);
	List<ImportRecord>findByImportJob(ImportJob job);

}
