package umc.workbook.service.MemberService;

import org.springframework.data.domain.Page;
import umc.workbook.domain.Mission;
import umc.workbook.domain.Review;

public interface MemberQueryService {

    Page<Review> getMemberReviewList(Long memberId, Integer page);
    Page<Mission> getMemberMissions(Long memberId, Integer page);
}
