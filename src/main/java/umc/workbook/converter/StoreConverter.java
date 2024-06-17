package umc.workbook.converter;

import umc.workbook.domain.Store;
import umc.workbook.web.dto.StoreDTO.StoreRequestDTO;
import umc.workbook.web.dto.StoreDTO.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store, Long regionId) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .regionId(regionId)
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
