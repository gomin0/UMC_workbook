package umc.workbook.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.workbook.domain.enums.MissionStatus;
import umc.workbook.repository.MemberMissionRepository;
import umc.workbook.validation.annotation.ChallengeMission;

@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<ChallengeMission, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(ChallengeMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isMissionChallenged = memberMissionRepository.existsByMissionIdAndStatus(missionId, MissionStatus.CHALLENGING);

        if (isMissionChallenged) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 미션은 이미 도전 중입니다.").addConstraintViolation();
        }

        return !isMissionChallenged;
    }
}