package umc.workbook.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.workbook.validation.annotation.CheckPage;

public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("페이지 번호는 1 이상이어야 합니다.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}