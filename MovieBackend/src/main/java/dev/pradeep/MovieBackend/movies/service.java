package dev.pradeep.MovieBackend.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {

    @Autowired
    movieRepo movieRepo;
    public List<movie> getAllMovies(){
        return movieRepo.findAll();
    }

    public Optional<movie> getMovieById(String imdbId){
        return movieRepo.findMovieByImdbId(imdbId);
    }


}
