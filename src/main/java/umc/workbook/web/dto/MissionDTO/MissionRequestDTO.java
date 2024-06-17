package umc.workbook.web.dto.MissionDTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class JoinDto{
        @NotNull
        Integer reward;
        @Future
        LocalDate deadline;
        @NotBlank
        String missionSpec;
    }
}
