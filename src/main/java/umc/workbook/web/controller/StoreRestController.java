package umc.workbook.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.converter.StoreConverter;
import umc.workbook.domain.Store;
import umc.workbook.service.StoreService.StoreCommandService;
import umc.workbook.web.dto.StoreDTO.StoreRequestDTO;
import umc.workbook.web.dto.StoreDTO.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{regionId}")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> joinStore(@RequestBody @Valid StoreRequestDTO.JoinDto request,
                                                                 @PathVariable Long regionId) {
        Store store = storeCommandService.joinStore(request, regionId);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store, regionId));
    }
}
