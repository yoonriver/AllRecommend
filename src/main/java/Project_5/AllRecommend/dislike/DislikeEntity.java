package Project_5.AllRecommend.dislike;

import Project_5.AllRecommend.member.MemberEntity;

import javax.persistence.*;

@Entity
public class DislikeEntity {

    @Id
    @Column(name = "DISLIKE_ID")
    @GeneratedValue
    private Long dislikeId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity memberEntity;

    private String dl_Content;

    public Long getDislikeId() {
        return dislikeId;
    }

    public void setDislikeId(Long dislikeId) {
        this.dislikeId = dislikeId;
    }

    public MemberEntity getMemberEntity() {
        return memberEntity;
    }

    public void setMemberEntity(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public String getDl_Content() {
        return dl_Content;
    }

    public void setDl_Content(String dl_Content) {
        this.dl_Content = dl_Content;
    }
}
