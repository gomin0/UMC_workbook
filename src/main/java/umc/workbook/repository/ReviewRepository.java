package umc.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.workbook.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
