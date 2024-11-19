package com.geppetto.testscreen.dao.daoimpl;

import com.geppetto.testscreen.repository.HosptitalordersRepository;
import com.geppetto.testscreen.dao.HosptitalordersDao;

import java.util.Optional;
import com.geppetto.testscreen.model.Hosptitalorders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
* Implementation of the {@link HosptitalordersDao} interface.
* Provides methods to interact with the {@link HosptitalordersRepository} for CRUD operations on {@link Hosptitalorders } entities.
*/
@Service
public class HosptitalordersDaoImpl implements HosptitalordersDao {

    private final HosptitalordersRepository hosptitalordersRepository;
    /**
     * Constructs a new {@code HosptitalordersDaoImpl} with the specified repository.
     *
     * @param hosptitalordersRepository The repository used for accessing {@link Hosptitalorders} entities. Must not be {@code null}.
     */
    public HosptitalordersDaoImpl(HosptitalordersRepository hosptitalordersRepository) {
        this.hosptitalordersRepository = hosptitalordersRepository;
    }

    /**
     * Retrieves hosptitalorders by its ID.
     *
     * @param id The ID of the hosptitalorders to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the hosptitalorders if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<Hosptitalorders> getHosptitalordersById(String id) {
        return hosptitalordersRepository.findById(id);
    }


    /**
     * Creates new hosptitalorders.
     *
     * @param hosptitalorders The {@link Hosptitalorders} entity to create. Must not be {@code null}.
     * @return The created {@link Hosptitalorders} entity.
     */
    @Override
    public Hosptitalorders createHosptitalorders(Hosptitalorders hosptitalorders) {
        return hosptitalordersRepository.save(hosptitalorders);
    }


    /**
     * Deletes hosptitalorders by its ID.
     *
     * @param id The ID of the hosptitalorders to delete. Must not be {@code null}.
     */
    @Override
    public void deleteHosptitalorders(String id) {
        hosptitalordersRepository.deleteById(id);
    }


    /**
     * Retrieves hosptitalorders by its ID for update purposes.
     *
     * @param id The ID of the hosptitalorders to retrieve. Must not be {@code null}.
     * @return An {@link Optional} containing the hosptitalorders if found, or an empty {@code Optional} if not.
     */
    @Override
    public Optional<Hosptitalorders> updateHosptitalorders(String id) {
        return hosptitalordersRepository.findById(id);
    }


     /**
     * Retrieves all hosptitalorders from the repository.
     *
     * @return A list of all {@link Hosptitalorders} entities.
     */
    @Override
    public Page<Hosptitalorders> getAllHosptitalorders(Pageable pageable) {
        return hosptitalordersRepository.findAll(pageable);
    }


}


