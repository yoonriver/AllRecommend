package Project_5.AllRecommend.repository;

import Project_5.AllRecommend.dislike.DislikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DislikeRepository extends JpaRepository<DislikeEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM DISLIKE WHERE MEMBER_ID = ?")
    List<DislikeEntity> findDislikeContentsById(Long id);

    @Query(nativeQuery = true, value = "SELECT dl_content FROM DISLIKE WHERE MEMBER_ID = ?")
    List<String> dl_ContentFindById(Long id);
}
