package Project_5.AllRecommend.repository;

import Project_5.AllRecommend.category.Category;
import Project_5.AllRecommend.dislike.DislikeEntity;

import java.util.List;

public interface MemberRepository {
    List<Category> allRecommend(DislikeEntity dislike);
}
