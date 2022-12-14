package in.sandeep.expanseApi.Repository;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sandeep.expanseApi.Entities.Expanse;

@Repository
public interface ExpanseRepository extends JpaRepository<Expanse, Long> {

	//SELECT * FROM tbl_expanses WHERE category=?
	Page<Expanse> findByCategory(String category,Pageable page);
	
	//SELECT * FROM tbl_expanses WHERE name LIKE '%keyword%'
	Page<Expanse> findByNameContaining(String keyword,Pageable page);
	
	//SELECT * FROM tbl_expanses WHERE date BETWEEN 'startDate' AND 'endDate'
	Page<Expanse> findByDateBetween(Date startDate,Date endDate,Pageable page);
}
