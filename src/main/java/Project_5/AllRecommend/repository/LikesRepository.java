package Project_5.AllRecommend.repository;

import Project_5.AllRecommend.dislike.DislikeEntity;
import Project_5.AllRecommend.dislike.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikesRepository extends JpaRepository<LikesEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT likes_Content FROM LIKES WHERE MEMBER_ID = ?")
    List<String> likesContentById(Long id);

}
