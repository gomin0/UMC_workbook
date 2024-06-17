package umc.workbook.web.dto.ReviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String title;
        @NotNull
        Float score;
    }
}
