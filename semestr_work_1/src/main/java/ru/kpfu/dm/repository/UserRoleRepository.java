package ru.kpfu.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.entity.UserRole;

/**
 * Created by Denis on 26.04.16.
 */

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
