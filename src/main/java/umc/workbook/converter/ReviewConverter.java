package umc.workbook.converter;

import umc.workbook.domain.Member;
import umc.workbook.domain.Review;
import umc.workbook.domain.Store;
import umc.workbook.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.workbook.web.dto.ReviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .memberId(1L)
                .storeId(review.getStore().getId())
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinDto request, Store store, Member member) {
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .store(store)
                .member(member)
                .build();
    }
}
