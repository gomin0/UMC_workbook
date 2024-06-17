package umc.workbook.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.converter.ReviewConverter;
import umc.workbook.domain.Review;
import umc.workbook.service.ReviewService.ReviewCommandService;
import umc.workbook.validation.annotation.StoreExists;
import umc.workbook.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.workbook.web.dto.ReviewDTO.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.JoinDto request,
                                                                  @StoreExists @PathVariable(name = "storeId") Long storeId) {
        Review review = reviewCommandService.addReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
