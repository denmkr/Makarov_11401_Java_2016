package ru.kpfu.dm.service;

import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.entity.UserRole;

import java.util.List;

/**
 * Created by Denis on 17.04.16.
 */
public interface UserRoleService {
    UserRole createUser(User user);
    void changeUserRole(User user);
    UserRole createAdmin(User user);
}