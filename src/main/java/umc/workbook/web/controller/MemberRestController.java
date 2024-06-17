package umc.workbook.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.workbook.apiPayload.ApiResponse;
import umc.workbook.converter.MemberConverter;
import umc.workbook.converter.MemberMissionConverter;
import umc.workbook.domain.Member;
import umc.workbook.domain.mapping.MemberMission;
import umc.workbook.service.MemberService.MemberCommandService;
import umc.workbook.validation.annotation.ChallengeMission;
import umc.workbook.web.dto.MemberDTO.MemberMissionResponseDTO;
import umc.workbook.web.dto.MemberDTO.MemberRequestDTO;
import umc.workbook.web.dto.MemberDTO.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/{missionId}")
    public ApiResponse<MemberMissionResponseDTO.JoinResultDTO> addMissionToMember(@ChallengeMission @PathVariable(name = "missionId") Long missionId) {
        MemberMission memberMission = memberCommandService.addMissionToMember(missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }
}