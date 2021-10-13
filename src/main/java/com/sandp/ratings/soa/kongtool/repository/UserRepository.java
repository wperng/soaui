package com.sandp.ratings.soa.kongtool.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sandp.ratings.soa.kongtool.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
    
}
