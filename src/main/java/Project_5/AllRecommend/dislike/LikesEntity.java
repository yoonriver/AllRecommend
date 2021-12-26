package Project_5.AllRecommend.dislike;

import Project_5.AllRecommend.member.MemberEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "LIKES")
public class LikeEntity {

    @Id
    @Column(name = "LIKES_ID")
    @GeneratedValue
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity memberEntity;

    private String like_Content;


}
