package umc.workbook.service.MemberService;

import umc.workbook.domain.Member;
import umc.workbook.domain.mapping.MemberMission;
import umc.workbook.web.dto.MemberDTO.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    MemberMission addMissionToMember(Long missionId);
}
