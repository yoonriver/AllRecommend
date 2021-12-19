package Project_5.AllRecommend.movie;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "MOVIE")
public class MovieEntity {

    @Id
    @Column(name = "MOVIE_ID")
    @GeneratedValue
    private Long movieId;

    private String movieTitle;

    private String cate1;

    private String cate2;

    public MovieEntity() {

    }
}
