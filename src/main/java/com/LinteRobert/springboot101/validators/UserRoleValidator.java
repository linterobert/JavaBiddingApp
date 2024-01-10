package com.LinteRobert.springboot101.validators;

import com.LinteRobert.springboot101.validatorsClass.UserRoleTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserRoleTypeValidator.class)
@Documented
public @interface UserRoleValidator {
    String message() default "Invalid role";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}