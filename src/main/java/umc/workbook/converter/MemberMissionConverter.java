package umc.workbook.converter;

import umc.workbook.domain.Member;
import umc.workbook.domain.Mission;
import umc.workbook.domain.mapping.MemberMission;
import umc.workbook.web.dto.MemberDTO.MemberMissionResponseDTO;

import java.time.LocalDateTime;

import static umc.workbook.domain.enums.MissionStatus.CHALLENGING;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.JoinResultDTO toJoinResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.JoinResultDTO.builder()
                .memberId(1L)
                .missionId(memberMission.getMission().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(Mission mission, Member member) {
        return MemberMission.builder()
                .mission(mission)
                .member(member)
                .status(CHALLENGING)
                .build();
    }
}
