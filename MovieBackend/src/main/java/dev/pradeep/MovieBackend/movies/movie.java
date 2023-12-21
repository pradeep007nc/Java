package dev.pradeep.MovieBackend.movies;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movies")
public class movie {

   @Id
   private ObjectId id;

   private String imdbId;

   private String title;

   private String releaseDate;

   private String trailerLink;

   private String poster;

   private List<String> genres;

   private List<String> backDrops;

   private List<review> reviewsIds;
}
