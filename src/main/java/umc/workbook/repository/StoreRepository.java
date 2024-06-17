package umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
