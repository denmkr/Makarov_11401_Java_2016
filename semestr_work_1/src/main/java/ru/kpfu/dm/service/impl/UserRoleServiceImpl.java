package ru.kpfu.dm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.entity.UserRole;
import ru.kpfu.dm.repository.ProductRepository;
import ru.kpfu.dm.repository.UserRoleRepository;
import ru.kpfu.dm.service.UserRoleService;

import javax.annotation.Resource;

/**
 * Created by Denis on 26.04.16.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public UserRole createUser(User user) {
        UserRole role = new UserRole();
        role.setUserId(user.getId());
        role.setAuthority("ROLE_USER");
        return userRoleRepository.save(role);
    }

    @Override
    @Transactional
    public void changeUserRole(User user) {

    }

    @Override
    @Transactional
    public UserRole createAdmin(User user) {
        UserRole role = new UserRole();
        role.setUserId(user.getId());
        role.setAuthority("ROLE_ADMIN");
        return userRoleRepository.save(role);
    }
}
