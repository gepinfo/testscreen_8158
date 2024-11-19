package com.geppetto.testscreen.dao;

import java.util.Optional;
import com.geppetto.testscreen.model.Hosptitalorders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface HosptitalordersDao {

    Optional<Hosptitalorders> getHosptitalordersById(String id);

    Hosptitalorders createHosptitalorders(Hosptitalorders hosptitalorders);

    void deleteHosptitalorders(String id);

    Optional<Hosptitalorders> updateHosptitalorders(String id);

    Page<Hosptitalorders> getAllHosptitalorders(Pageable pageable);

}

