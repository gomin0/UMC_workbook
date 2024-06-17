package umc.workbook.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.converter.MissionConverter;
import umc.workbook.domain.Mission;
import umc.workbook.service.MissionService.MissionCommandService;
import umc.workbook.web.dto.MissionDTO.MissionRequestDTO;
import umc.workbook.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.JoinDto request,
                                                                    @PathVariable Long storeId) {
        Mission mission = missionCommandService.addMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}
