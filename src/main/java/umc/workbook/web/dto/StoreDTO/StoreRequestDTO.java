package umc.workbook.web.dto.StoreDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotBlank
        String address;
    }
}