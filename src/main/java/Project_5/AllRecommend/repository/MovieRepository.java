package Project_5.AllRecommend.repository;

import Project_5.AllRecommend.dislike.DislikeEntity;
import Project_5.AllRecommend.dislike.LikesEntity;
import Project_5.AllRecommend.movie.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    @Query(nativeQuery = true, value = "select * from movie where cate1 not in :dislikes and cate2 not in :dislikes")
    List<MovieEntity> movieListWithoutDislikes(@Param("dislikes") List<String> dislikes);

    @Query(nativeQuery = true, value = "select * from (select * from movie where cate1 not in (:dislikes) and cate2 not in (:dislikes)) as m " +
                                                    "where m.cate1 in (:likes) or m.cate2 in (:likes)")
    List<MovieEntity> movieListFindByLikesWithoutDislikes(@Param("dislikes") List<String> dislikes, @Param("likes") List<String> likes);

}
