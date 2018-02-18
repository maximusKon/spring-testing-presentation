package ru.maximov.springtestingpresentation.controllers;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(path = "/rock_band")
public class RockBandController {

    RockBandService rockBandService;

    @Autowired
    public RockBandController(RockBandService rockBandService) {
        this.rockBandService = rockBandService;
    }

    @RequestMapping(path = "/{id}")
    public RockBand getById(@PathVariable("id") long id) throws NoSuchObjectException {
        return rockBandService.getById(id);
    }

    @RequestMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void post(@RequestBody RockBand rockBand) {
        rockBandService.add(rockBand);
    }

    @ExceptionHandler(NoSuchObjectException.class)
    private ResponseEntity<String> handleNoSuchObjectException(NoSuchObjectException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
