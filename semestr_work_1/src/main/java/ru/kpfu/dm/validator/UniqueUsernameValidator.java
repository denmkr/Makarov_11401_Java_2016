package ru.kpfu.dm.validator;

/**
 * Created by Denis on 04.05.16.
 */
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(UniqueUsername paramA) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext ctx) {
        if(username == null) {
            return false;
        }

        User user = userService.findByUsername(username);
        if (user == null) {
            return true;
        }

        return false;

    }

}