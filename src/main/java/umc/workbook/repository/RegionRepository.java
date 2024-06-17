package umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
