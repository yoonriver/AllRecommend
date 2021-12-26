package Project_5.AllRecommend.repository;

import Project_5.AllRecommend.dislike.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
}
