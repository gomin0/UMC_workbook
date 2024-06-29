package umc.workbook.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook.apiPayload.code.status.ErrorStatus;
import umc.workbook.apiPayload.exception.handler.MissionHandler;
import umc.workbook.apiPayload.exception.handler.StoreHandler;
import umc.workbook.converter.MissionConverter;
import umc.workbook.domain.Mission;
import umc.workbook.domain.Store;
import umc.workbook.domain.enums.MissionStatus;
import umc.workbook.domain.mapping.MemberMission;
import umc.workbook.repository.MemberMissionRepository;
import umc.workbook.repository.MissionRepository;
import umc.workbook.repository.StoreRepository;
import umc.workbook.web.dto.MissionDTO.MissionRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Mission addMission(Long storeId, MissionRequestDTO.JoinDto request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, store);

        return missionRepository.save(newMission);
    }

    @Override
    public MemberMission missionComplete(Long memberId, Long missionId) {
        MemberMission mission = memberMissionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        mission.setStatus(MissionStatus.COMPLETE);
        memberMissionRepository.save(mission);

        return mission;
    }
}
