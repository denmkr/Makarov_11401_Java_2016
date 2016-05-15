package ru.kpfu.dm.service;

import ru.kpfu.dm.entity.User;

import java.util.List;

/**
 * Created by Denis on 17.04.16.
 */
public interface UserService {
    User create(User user);
    User delete(long id);
    List<User> findAll();
    User findById(long id);
    User findByUsername(String username);
    User findByEmail(String email);
}