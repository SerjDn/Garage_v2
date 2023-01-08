package com.example.garage_v2.repository;

import com.example.garage_v2.model.UserGarage;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGarageRepo extends CrudRepository<UserGarage, Integer> {

    @Query("""
            SELECT * FROM public.user as t1
                FULL JOIN public.car as t2
                ON t1.id = t2.userid
                WHERE t1.id = (:id)
                ORDER BY t2.brand ASC, t2.model ASC
            """)
    List<UserGarage> findUserGarageByUserId(@Param("id") int id);

    @Query("""
           SELECT * FROM public.user as t1
                LEFT JOIN public.car as t2
                ON t1.id = t2.userid
                ORDER BY t1.id ASC, t2.brand ASC, t2.model ASC
           """)
    List<UserGarage> findAllUserGarages();
}
