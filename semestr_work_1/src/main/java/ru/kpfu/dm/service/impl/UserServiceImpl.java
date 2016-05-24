package ru.kpfu.dm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.repository.UserRepository;
import ru.kpfu.dm.service.UserService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    public UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(12);
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        java.util.Date date = new java.util.Date();
        user.setDate(new Timestamp(date.getTime()));

        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public User findById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Long countOfUsers() {
        return userRepository.countOfUsers();
    }

    @Override
    @Transactional
    public User delete(long id) {
        User deletedUser = userRepository.findOne(id);
        userRepository.delete(deletedUser);
        return deletedUser;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

}