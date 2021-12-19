package Project_5.AllRecommend.member;

import Project_5.AllRecommend.dislike.DislikeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MemberEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @OneToMany(mappedBy = "memberEntity")
    private List<DislikeEntity> likeList = new ArrayList<>();

    public Long getId() {
        return memberId;
    }

    public void setId(Long id) {
        this.memberId = id;
    }

}
