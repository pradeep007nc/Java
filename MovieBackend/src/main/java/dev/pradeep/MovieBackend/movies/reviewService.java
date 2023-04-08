package dev.pradeep.MovieBackend.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class reviewService {
    @Autowired
    reviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public review createReview(String reviewBody, String imdbId){
        review review =  reviewRepo.insert(new review(reviewBody));


        //mongo template writes the low level query code itself
        //here the imdb id is matched and then reviewId pair is to be
        // updated this creates a empty array and then push into update object
        mongoTemplate.update(movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        //now the query is fired the review body is updated
        return review;
    }
}
