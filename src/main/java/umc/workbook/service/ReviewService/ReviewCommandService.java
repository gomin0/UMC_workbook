package umc.workbook.service.ReviewService;

import umc.workbook.domain.Review;
import umc.workbook.web.dto.ReviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(Long storeId, ReviewRequestDTO.JoinDto request);
}
