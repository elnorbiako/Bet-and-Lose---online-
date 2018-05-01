package pl.betandlose.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.betandlose.service.FakerService;

@RestController
@RequestMapping("/api")
public class FakerResource {

    @Autowired
    FakerService fakerService;

    @GetMapping(path= "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path= "/fake-today-games")
    public String sample() {
        fakerService.regenerate();
        return fakerService.getTodayGames().toString();
    }
}