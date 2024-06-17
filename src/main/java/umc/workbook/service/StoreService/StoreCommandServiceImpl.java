package umc.workbook.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.workbook.apiPayload.code.status.ErrorStatus;
import umc.workbook.apiPayload.exception.handler.RegionHandler;
import umc.workbook.converter.StoreConverter;
import umc.workbook.domain.Region;
import umc.workbook.domain.Store;
import umc.workbook.repository.RegionRepository;
import umc.workbook.repository.StoreRepository;
import umc.workbook.web.dto.StoreDTO.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store joinStore(StoreRequestDTO.JoinDto request, Long regionId) {

        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request);
        newStore.setRegion(region);

        return storeRepository.save(newStore);
    }
}
