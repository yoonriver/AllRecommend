package Project_5.AllRecommend;


import Project_5.AllRecommend.dislike.DislikeEntity;
import Project_5.AllRecommend.dislike.LikesEntity;
import Project_5.AllRecommend.member.MemberEntity;
import Project_5.AllRecommend.movie.MovieEntity;
import Project_5.AllRecommend.repository.DislikeRepository;
import Project_5.AllRecommend.repository.MemberRepository;
import Project_5.AllRecommend.repository.LikesRepository;
import Project_5.AllRecommend.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class test {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DislikeRepository dislikeRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private LikesRepository likeRepository;

    @Test
    public void dlTest() {
        // 멤버 생성
        MemberEntity member = new MemberEntity();
        memberRepository.save(member);

        // 영화 목록 작성
        MovieEntity movieEntity1 = new MovieEntity();
        movieEntity1.setMovieTitle("미션 임파서블");
        movieEntity1.setCate1("액션");
        movieEntity1.setCate2("블록버스터");
        movieRepository.save(movieEntity1);

        MovieEntity movieEntity2 = new MovieEntity();
        movieEntity2.setMovieTitle("새벽의 저주");
        movieEntity2.setCate1("공포");
        movieEntity2.setCate2("스릴러");
        movieRepository.save(movieEntity2);

        MovieEntity movieEntity3 = new MovieEntity();
        movieEntity3.setMovieTitle("라라랜드");
        movieEntity3.setCate1("로맨스");
        movieEntity3.setCate2("뮤지컬");
        movieRepository.save(movieEntity3);

        MovieEntity movieEntity4 = new MovieEntity();
        movieEntity4.setMovieTitle("어바웃 타임");
        movieEntity4.setCate1("코미디");
        movieEntity4.setCate2("로맨스");
        movieRepository.save(movieEntity4);

        MovieEntity movieEntity5 = new MovieEntity();
        movieEntity5.setMovieTitle("가디언즈오브갤럭시");
        movieEntity5.setCate1("SF");
        movieEntity5.setCate2("히어로");
        movieRepository.save(movieEntity5);

        // 멤버에 싫어하는 장르 데이터 입력
        DislikeEntity dislike1 = new DislikeEntity();
        dislike1.setMemberEntity(member);
        dislike1.setDl_Content("액션");

        DislikeEntity dislike2 = new DislikeEntity();
        dislike2.setMemberEntity(member);
        dislike2.setDl_Content("코미디");

        dislikeRepository.save(dislike1);
        dislikeRepository.save(dislike2);



        // 멤버에 좋아하는 장르 데이터 입력
        LikesEntity likes1 = new LikesEntity();
        likes1.setMemberEntity(member);
        likes1.setLikes_Content("히어로");

        LikesEntity likes2 = new LikesEntity();
        likes2.setMemberEntity(member);
        likes2.setLikes_Content("공포");

        likeRepository.save(likes1);
        likeRepository.save(likes2);


        // 회원이 싫어하는와 좋아하는 장르를 List<String>으로 저장
        List<String> dislikeStr = dislikeRepository.dl_ContentFindById(member.getId());
        List<MovieEntity> movieDislikesList = movieRepository.movieListWithoutDislikes(dislikeStr);

        // 싫어하는 장르를 제외한 영화 목록에서 좋아하는 장르만 가져오기
        List<String> likesStr = likeRepository.likesContentById(member.getId());
        List<MovieEntity> movieLikesList = movieRepository.movieListFindByLikesWithoutDislikes(dislikeStr, likesStr);


        // 출력
        for (MovieEntity dislikeMovieEntity : movieDislikesList) {
            System.out.println("dislikeMovieEntity.getMovieTitle() = " + dislikeMovieEntity.getMovieTitle());
        }

        for (MovieEntity likesMovieEntity : movieLikesList) {
            System.out.println("likesMovieEntity.getMovieTitle() = " + likesMovieEntity.getMovieTitle());
        }
    }

}
