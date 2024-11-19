package com.geppetto.testscreen.service;

import com.geppetto.testscreen.dto.HosptitalordersDto;
import org.springframework.data.domain.Page;

public interface HosptitalordersService {

    HosptitalordersDto  getHosptitalordersById(String id);

    HosptitalordersDto  createHosptitalorders(HosptitalordersDto hosptitalordersDto);

    String  deleteHosptitalorders(String id);

    HosptitalordersDto  updateHosptitalorders(HosptitalordersDto hosptitalordersDto);

    Page<HosptitalordersDto>  getAllHosptitalorders(int page, int size);

}
