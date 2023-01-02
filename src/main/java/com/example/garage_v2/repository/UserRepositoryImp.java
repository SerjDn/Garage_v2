package com.example.garage_v2.repository;

import com.example.garage_v2.model.User;
import com.example.garage_v2.model.UserCars;
import com.example.garage_v2.repository.dao.UserRepository;
import com.example.garage_v2.repository.mapper.UserCarsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserCars> getUser(int id) {
        return jdbcTemplate.query("""
                SELECT * FROM public.user as t1
                	FULL JOIN public.car as t2
                	ON t1.id = t2.userid
                	WHERE t1.id = """ + id, new UserCarsMapper());
    }

    @Override
    public List<UserCars> getUsers() {
        return jdbcTemplate.query("""
                SELECT * FROM public.user as t1
                	FULL JOIN public.car as t2
                	ON t1.id = t2.userid
                	ORDER BY t1.id ASC
                """, new UserCarsMapper());
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update("""
                INSERT INTO public.user(
                   	name)
                   	VALUES (?);
                """, user.getName());
    }

    @Override
    public void AddCarToUser(int userId, int carId) {
        jdbcTemplate.update("""
                UPDATE public.car
                   	SET userid = (?)
                   	WHERE id IN (?);
                """, userId, carId);
    }
}
