package umc.workbook.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.workbook.apiPayload.code.status.ErrorStatus;
import umc.workbook.apiPayload.exception.handler.FoodCategoryHandler;
import umc.workbook.apiPayload.exception.handler.MemberHandler;
import umc.workbook.apiPayload.exception.handler.MissionHandler;
import umc.workbook.converter.MemberConverter;
import umc.workbook.converter.MemberMissionConverter;
import umc.workbook.converter.MemberPreferConverter;
import umc.workbook.domain.FoodCategory;
import umc.workbook.domain.Member;
import umc.workbook.domain.Mission;
import umc.workbook.domain.mapping.MemberMission;
import umc.workbook.domain.mapping.MemberPrefer;
import umc.workbook.repository.FoodCategoryRepository;
import umc.workbook.repository.MemberMissionRepository;
import umc.workbook.repository.MemberRepository;
import umc.workbook.repository.MissionRepository;
import umc.workbook.web.dto.MemberDTO.MemberRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> foodCategoryRepository.findById(category)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).toList();

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        for (MemberPrefer memberPrefer : memberPreferList) {
            memberPrefer.setMember(newMember);
        }

        return memberRepository.save(newMember);
    }

    @Override
    public MemberMission addMissionToMember(Long missionId) {

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 하드 코딩된 멤버
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(mission, member);

        return memberMissionRepository.save(memberMission);
    }
}