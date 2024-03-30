package dev.pradeep.WebFluxVideoStream.Controller;

import dev.pradeep.WebFluxVideoStream.Services.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class VideoController {

    @Autowired
    private StreamingService service;


    @GetMapping(value = "videos/{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println("range in bytes() : " + range);
        return service.getVideo(title);
    }


}
