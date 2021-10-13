package com.sandp.ratings.soa.kongtool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sandp.ratings.soa.kongtool.entity.API;


@Repository
public interface APIRepository extends CrudRepository<API, String>{
    
}
