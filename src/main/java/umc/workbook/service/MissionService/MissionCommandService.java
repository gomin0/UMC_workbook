package umc.workbook.service.MissionService;

import umc.workbook.domain.Mission;
import umc.workbook.domain.mapping.MemberMission;
import umc.workbook.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {

    Mission addMission(Long storeId, MissionRequestDTO.JoinDto request);

    MemberMission missionComplete(Long memberId, Long missionId);
}
