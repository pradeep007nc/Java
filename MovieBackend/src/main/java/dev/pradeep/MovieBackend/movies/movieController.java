package dev.pradeep.MovieBackend.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class movieController {


    @Autowired
    private service service;

    @GetMapping("/allMovies")
    public ResponseEntity<List<movie>> allMovies(){
        return new ResponseEntity<List<movie>>(service.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/allMovies/{id}")
    public ResponseEntity<Optional<movie>> getMovie(@PathVariable String id){
        return new ResponseEntity<>(service.movieRepo.findMovieByImdbId(id), HttpStatus.OK);
    }

}
