package com.example.garage_v2.repository;

import com.example.garage_v2.model.User;
import com.example.garage_v2.model.UserGarage;
import com.example.garage_v2.repository.dao.UserRepository;
import com.example.garage_v2.repository.mapper.UserGarageMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String selectUser = """
            SELECT * FROM public.user as t1
                FULL JOIN public.car as t2
                ON t1.id = t2.userid
                WHERE t1.id =
            """;

    private static final String selectUsers = """
            SELECT * FROM public.user as t1
                LEFT JOIN public.car as t2
                ON t1.id = t2.userid
                ORDER BY t1.id ASC, t2.brand ASC, t2.model ASC
            """;

    private static final String insertUser = """
            INSERT INTO public.user(
                name)
                VALUES (?)
            """;

    private static final String updateUserCar = """
            UPDATE public.car
                SET userid = (?)
                WHERE id = (?)
            """;

    @Override
    public List<UserGarage> getUser(int id) {
        return jdbcTemplate.query(selectUser + id, new UserGarageMapper());
    }

    @Override
    public List<UserGarage> getUsers() {
        return jdbcTemplate.query(selectUsers, new UserGarageMapper());
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(insertUser, user.getName());
    }

    @Override
    public void AddCarToUser(int userId, int carId) {
        jdbcTemplate.update(updateUserCar, userId, carId);
    }
}
