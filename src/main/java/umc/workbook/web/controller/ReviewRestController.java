package umc.workbook.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.converter.ReviewConverter;
import umc.workbook.converter.StoreConverter;
import umc.workbook.domain.Review;
import umc.workbook.service.MemberService.MemberQueryService;
import umc.workbook.service.ReviewService.ReviewCommandService;
import umc.workbook.service.StoreService.StoreQueryService;
import umc.workbook.validation.annotation.CheckPage;
import umc.workbook.validation.annotation.StoreExists;
import umc.workbook.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.workbook.web.dto.ReviewDTO.ReviewResponseDTO;
import umc.workbook.web.dto.StoreDTO.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final StoreQueryService storeQueryService;
    private final MemberQueryService memberQueryService;


    @PostMapping("/{storeId}")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.JoinDto request,
                                                                  @StoreExists @PathVariable(name = "storeId") Long storeId) {
        Review review = reviewCommandService.addReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }

    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "사용자가 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/myReviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getMyReviewList(
            @CheckPage @RequestParam(name = "page") Integer page) {

        Page<Review> reviewList = memberQueryService.getMemberReviewList(1L, page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }

    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/storeReviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
            @StoreExists @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}
