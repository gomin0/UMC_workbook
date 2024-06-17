package umc.workbook.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.workbook.validation.validator.MissionChallengeValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionChallengeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ChallengeMission {
    String message() default "해당 미션은 이미 도전 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
