package Project_5.AllRecommend.dislike;

import Project_5.AllRecommend.member.MemberEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "LIKES")
public class LikesEntity {

    @Id
    @Column(name = "LIKES_ID")
    @GeneratedValue
    private Long likesId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity memberEntity;

    private String likes_Content;

    public Long getLikesId() {
        return likesId;
    }

    public void setLikesId(Long likesId) {
        this.likesId = likesId;
    }

    public MemberEntity getMemberEntity() {
        return memberEntity;
    }

    public void setMemberEntity(MemberEntity memberEntity) {
        memberEntity.getLikes().add(this);
        this.memberEntity = memberEntity;
    }

    public String getLikes_Content() {
        return likes_Content;
    }

    public void setLikes_Content(String likes_Content) {
        this.likes_Content = likes_Content;
    }
}
