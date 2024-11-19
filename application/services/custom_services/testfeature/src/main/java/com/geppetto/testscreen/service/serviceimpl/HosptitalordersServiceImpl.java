package com.geppetto.testscreen.service.serviceimpl;

import com.geppetto.testscreen.dao.HosptitalordersDao;
import com.geppetto.testscreen.dto.HosptitalordersDto;
import com.geppetto.testscreen.exception.EntityNotFoundException;
import com.geppetto.testscreen.model.Hosptitalorders;
import com.geppetto.testscreen.service.HosptitalordersService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


/**
* Implementation of the {@link HosptitalordersService} interface.
* Provides services related to Hosptitalorders, including CRUD operations and file uploads/downloads.
*/

@Service
@Slf4j
public class HosptitalordersServiceImpl implements HosptitalordersService {


    /**
     * Constructs a {@code HosptitalordersServiceImpl} with the specified DAO and MongoTemplate.
     *
     * @param hosptitalordersDao The DAO for accessing the data.
     * @param mongoTemplate The MongoTemplate for interacting with MongoDB.
     */
  private final HosptitalordersDao hosptitalordersDao;
  private final MongoTemplate mongoTemplate;

  public HosptitalordersServiceImpl(HosptitalordersDao  hosptitalordersDao, MongoTemplate mongoTemplate) {
    this. hosptitalordersDao =  hosptitalordersDao;
    this.mongoTemplate = mongoTemplate;
  }
    
    /**
     * Retrieves hosptitalorders by its ID.
     *
     * @param id The ID of the hosptitalorders to retrieve. Must not be {@code null}.
     * @return The hosptitalorders data transfer object associated with the specified ID.
     * @throws EntityNotFoundException If no hosptitalorders with the specified ID is found.
     */
  @Override
  public HosptitalordersDto  getHosptitalordersById(String id) {
    log.info("Enter into getHosptitalordersById method");
    return hosptitalordersDao.getHosptitalordersById(id)
    .map(hosptitalorders -> {
      HosptitalordersDto hosptitalordersDto = new HosptitalordersDto();
      BeanUtils.copyProperties(hosptitalorders, hosptitalordersDto);
      log.info("Exit from getHosptitalordersById method");
      return hosptitalordersDto;
    })
        .orElseThrow(() -> new EntityNotFoundException("Data not found for ID: " + id));
  }
    
    /**
     * Creates new hosptitalorders.
     *
     * @param hosptitalordersDto The {@link HosptitalordersDto} to be created.
     * @return The created {@link HosptitalordersDto}.
     */
  @Override
  public HosptitalordersDto  createHosptitalorders(HosptitalordersDto hosptitalordersDto) {
    log.info("Enter into createHosptitalorders method");
    Hosptitalorders hosptitalorders = new Hosptitalorders();
  BeanUtils.copyProperties(hosptitalordersDto, hosptitalorders);
  Hosptitalorders createdHosptitalorders= hosptitalordersDao.createHosptitalorders(hosptitalorders);
  BeanUtils.copyProperties(createdHosptitalorders, hosptitalordersDto);
  log.info("Exit from createHosptitalorders method");
  return hosptitalordersDto;
  }
    
    /**
     * Deletes hosptitalorders by ID.
     *
     * @param id The ID of the hosptitalorders to delete.
     * @return A message indicating the result of the deletion.
     * @throws EntityNotFoundException If no hosptitalorders with the specified ID is found.
     */
  @Override
  public String  deleteHosptitalorders(String id) {
    log.info("Enter into deleteHosptitalorders method");
    return hosptitalordersDao.getHosptitalordersById(id)
     .map(hosptitalorders -> {
     hosptitalordersDao.deleteHosptitalorders(id);
  log.info("Exit from deleteHosptitalorders method");
  return "Data Deleted Successfully";
  })
  .orElseThrow(() -> new EntityNotFoundException("No entry found with ID: " + id + ". Unable to delete."));

  }
    
    /**
     * Updates existing hosptitalorders.
     *
     * @param hosptitalordersDto The {@link HosptitalordersDto} containing updated information.
     * @return The updated {@link HosptitalordersDto}.
     * @throws EntityNotFoundException If no hosptitalorders with the specified ID is found.
     */
  @Override
  public HosptitalordersDto  updateHosptitalorders(HosptitalordersDto hosptitalordersDto) {
    log.info("Enter into updateHosptitalorders method");
    return hosptitalordersDao.getHosptitalordersById(hosptitalordersDto.getId())
    .map(existingHosptitalorders -> {
      BeanUtils.copyProperties(hosptitalordersDto, existingHosptitalorders);
      hosptitalordersDao.createHosptitalorders(existingHosptitalorders);
      log.info("Exit from updateHosptitalorders method");
      return hosptitalordersDto;
  })
  .orElseThrow(() -> new EntityNotFoundException("Data not found for update with ID: " + hosptitalordersDto.getId()));
  }
    
    /**
     * Retrieves all hosptitalorders.
     *
     * @return A list of {@link HosptitalordersDto} representing all hosptitalorders.
     */
  @Override
  public Page<HosptitalordersDto>  getAllHosptitalorders(int page, int size) {
    log.info("Enter into getAllHosptitalorders method");
    Pageable pageable = (Pageable) PageRequest.of(page, size);
    Page<Hosptitalorders> hosptitalordersPage =hosptitalordersDao.getAllHosptitalorders(pageable);
    Page<HosptitalordersDto>hosptitalordersDtoPage = hosptitalordersPage.map(hosptitalorders -> {
    HosptitalordersDto hosptitalordersDto = HosptitalordersDto.builder().build();
    BeanUtils.copyProperties(hosptitalorders, hosptitalordersDto);
    return hosptitalordersDto;
    });
    log.info("Exit from getAllhosptitalordersmethod");
    return hosptitalordersDtoPage;
  }
    

}
