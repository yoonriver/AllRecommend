package Project_5.AllRecommend.repository;

import Project_5.AllRecommend.movie.MovieEntity;
import Project_5.AllRecommend.dislike.DislikeEntity;

import java.util.List;

public interface MemberRepository {
    List<MovieEntity> allRecommend(DislikeEntity dislike);
}
