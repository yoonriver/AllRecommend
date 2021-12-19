package Project_5.AllRecommend.repository;

import Project_5.AllRecommend.dislike.DislikeEntity;
import Project_5.AllRecommend.movie.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    @Query(nativeQuery = true, value = "select * from movie as m where not exists (select * from dislike as d where m.cate1 = d.dl_content or m.cate2 = d.dl_content)")
    List<MovieEntity> movieListWithoutDislikes();
}
