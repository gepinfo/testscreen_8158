package com.geppetto.testscreen.repository;

import com.geppetto.testscreen.model.Hosptitalorders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface HosptitalordersRepository extends MongoRepository<Hosptitalorders,String>  {
    
    Page<Hosptitalorders> findAll(Pageable pageable);

}
