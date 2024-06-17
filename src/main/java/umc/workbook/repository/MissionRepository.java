package umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
