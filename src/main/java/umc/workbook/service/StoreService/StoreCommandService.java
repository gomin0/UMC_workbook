package umc.workbook.service.StoreService;

import umc.workbook.domain.Store;
import umc.workbook.web.dto.StoreDTO.StoreRequestDTO;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.JoinDto request, Long regionId);
}
