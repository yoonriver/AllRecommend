package Project_5.AllRecommend.member;

import Project_5.AllRecommend.dislike.DislikeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class MemberEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "memberEntity")
    private List<DislikeEntity> dislikeList = new ArrayList<>();


}
