package umc.workbook.service.MissionService;

import umc.workbook.domain.Mission;
import umc.workbook.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {

    Mission addMission(Long storeId, MissionRequestDTO.JoinDto request);
}
