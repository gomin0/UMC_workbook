package umc.workbook.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.workbook.repository.StoreRepository;
import umc.workbook.validation.annotation.StoreExists;

@Component
@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<StoreExists, Long> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(StoreExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        boolean exists = storeRepository.existsById(storeId);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 가게가 존재하지 않습니다.").addConstraintViolation();
        }

        return exists;
    }
}
