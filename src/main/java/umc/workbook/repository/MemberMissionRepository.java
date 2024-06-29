package umc.workbook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.workbook.domain.Member;
import umc.workbook.domain.Mission;
import umc.workbook.domain.enums.MissionStatus;
import umc.workbook.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus missionStatus);

    @Query("SELECT mm.mission FROM MemberMission mm " +
            "WHERE mm.member = :member AND mm.status = :status")
    Page<Mission> findAllByMemberAndInChallenging(@Param("member") Member member,
                                                  @Param("status") MissionStatus status,
                                                  PageRequest of);
}
