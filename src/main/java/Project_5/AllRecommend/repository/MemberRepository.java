package Project_5.AllRecommend.repository;

import Project_5.AllRecommend.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<MemberEntity, Long> {


}
