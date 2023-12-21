package dev.pradeep.MovieBackend.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.ObjectInput;
import java.util.Optional;

@Repository
public interface movieRepo extends MongoRepository<movie, ObjectId> {
    Optional<movie> findMovieByImdbId(String ImdbId);
}
