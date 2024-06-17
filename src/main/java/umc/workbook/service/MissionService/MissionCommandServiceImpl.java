package umc.workbook.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.workbook.apiPayload.code.status.ErrorStatus;
import umc.workbook.apiPayload.exception.handler.StoreHandler;
import umc.workbook.converter.MissionConverter;
import umc.workbook.domain.Mission;
import umc.workbook.domain.Store;
import umc.workbook.repository.MissionRepository;
import umc.workbook.repository.StoreRepository;
import umc.workbook.web.dto.MissionDTO.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission addMission(Long storeId, MissionRequestDTO.JoinDto request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, store);

        return missionRepository.save(newMission);
    }
}
