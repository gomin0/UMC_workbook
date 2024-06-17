package umc.workbook.converter;

import umc.workbook.domain.Mission;
import umc.workbook.domain.Store;
import umc.workbook.web.dto.MissionDTO.MissionRequestDTO;
import umc.workbook.web.dto.MissionDTO.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.JoinDto request, Store store) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();
    }
}
