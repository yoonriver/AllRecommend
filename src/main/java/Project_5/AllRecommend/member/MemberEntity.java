package Project_5.AllRecommend.member;

import Project_5.AllRecommend.dislike.DislikeEntity;
import Project_5.AllRecommend.dislike.LikesEntity;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
public class MemberEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "memberEntity")
    private List<DislikeEntity> dislikes = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity")
    private List<LikesEntity> likes = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public List<DislikeEntity> getDislikes() {
        return dislikes;
    }

    public List<LikesEntity> getLikes() {
        return likes;
    }
}
