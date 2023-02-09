package com.example.garage_v2.repository;

import com.example.garage_v2.model.Auth;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<Auth, String> {

    @Query("""
            SELECT * FROM "auth"
            WHERE name = (:name);
            """)
    Auth getAuthByName(@Param("name") String name);
}
