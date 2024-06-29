package umc.workbook.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook.apiPayload.code.status.ErrorStatus;
import umc.workbook.apiPayload.exception.handler.StoreHandler;
import umc.workbook.apiPayload.exception.handler.MemberHandler;
import umc.workbook.converter.ReviewConverter;
import umc.workbook.domain.Member;
import umc.workbook.domain.Review;
import umc.workbook.domain.Store;
import umc.workbook.repository.MemberRepository;
import umc.workbook.repository.ReviewRepository;
import umc.workbook.repository.StoreRepository;
import umc.workbook.web.dto.ReviewDTO.ReviewRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public Review addReview(Long storeId, ReviewRequestDTO.JoinDto request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        // 하드 코딩된 멤버
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Review review = ReviewConverter.toReview(request, store, member);

        return reviewRepository.save(review);
    }
}
