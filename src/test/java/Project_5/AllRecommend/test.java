package Project_5.AllRecommend;


import Project_5.AllRecommend.dislike.DislikeEntity;
import Project_5.AllRecommend.member.MemberEntity;
import Project_5.AllRecommend.repository.DislikeRepository;
import Project_5.AllRecommend.repository.JpaMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class test {

    @Autowired
    private JpaMemberRepository jpaMemberRepository;

    @Autowired
    private DislikeRepository dislikeRepository;

    @Test
    public void dlTest() {
        MemberEntity memberEntity = new MemberEntity();
        jpaMemberRepository.save(memberEntity);

        DislikeEntity dislike1 = new DislikeEntity();
        dislike1.setMemberEntity(memberEntity);
        dislike1.setDl_Content("액션");

        DislikeEntity dislike2 = new DislikeEntity();
        dislike2.setMemberEntity(memberEntity);
        dislike2.setDl_Content("코미디");


        dislikeRepository.save(dislike1);
        dislikeRepository.save(dislike2);

        List<DislikeEntity> dislikeContentsById = dislikeRepository.findDislikeContentsById(memberEntity.getId());
        System.out.println("dislikeContentsById = " + dislikeContentsById);
        for (DislikeEntity dislike : dislikeContentsById) {
            System.out.println(dislike.getDl_Content());
        }

    }

}
