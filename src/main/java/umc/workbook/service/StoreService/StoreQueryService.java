package umc.workbook.service.StoreService;

import org.springframework.data.domain.Page;
import umc.workbook.domain.Review;
import umc.workbook.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
