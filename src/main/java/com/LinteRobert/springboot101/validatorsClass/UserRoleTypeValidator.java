package com.LinteRobert.springboot101.validatorsClass;

import com.LinteRobert.springboot101.validators.UserRoleValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class UserRoleTypeValidator implements ConstraintValidator<UserRoleValidator, String> {
    @Override
    public boolean isValid(String role, ConstraintValidatorContext constraintValidatorContext) {
        List<String> userRoles = Arrays.asList("buyer", "seller", "admin");
        return userRoles.contains(role);
    }
}
