package umc.workbook.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.workbook.validation.validator.StoreExistsValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StoreExistsValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface StoreExists {
    String message() default "해당 가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
