package umc.workbook.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook.apiPayload.code.status.ErrorStatus;
import umc.workbook.apiPayload.exception.handler.MemberHandler;
import umc.workbook.domain.Member;
import umc.workbook.domain.Mission;
import umc.workbook.domain.Review;
import umc.workbook.domain.enums.MissionStatus;
import umc.workbook.repository.MemberMissionRepository;
import umc.workbook.repository.MemberRepository;
import umc.workbook.repository.MissionRepository;
import umc.workbook.repository.ReviewRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {
    
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Review> getMemberReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getMemberMissions(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return memberMissionRepository.findAllByMemberAndInChallenging(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
    }
}
