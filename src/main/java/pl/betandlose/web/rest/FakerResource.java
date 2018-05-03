package pl.betandlose.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FakerResource {

    @Autowired
    FakerService fakerService;
    @Autowired
    FakerCountryService fakerCountryService;
    @Autowired
    FakerUserService fakerUserService;

    @GetMapping(path= "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path= "/fake-today-games")
    public String sample() {
        return fakerService.getTodayGames().toString();
    }

    @GetMapping(path= "/fake-countries")
    public String country() {
        return fakerCountryService.getCountries().toString();
    }

    @GetMapping(path= "/fake-users")
    public String users() {
        return fakerUserService.getFakeUsers().toString();
    }

}