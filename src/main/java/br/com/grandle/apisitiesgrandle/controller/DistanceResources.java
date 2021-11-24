package br.com.grandle.apisitiesgrandle.controller;

import br.com.grandle.apisitiesgrandle.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project api-sities-grandle
 * Created by Leandro Saniago on 23/11/2021 - 16:28.
 */
@RestController
@RequestMapping("/distances")
public class DistanceResources {

    private final DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceResources.class);

    @Autowired
    public DistanceResources(DistanceService service) {
        this.service = service;
    }

    //http://localhost:8080/distances/by-points?from=4929&to=5254 retorno em milhas
    @GetMapping("/by-points")
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
    }

    //http://localhost:8080/distances/by-cube?from=4929&to=5254 retorna em metros
    @GetMapping("/by-cube")
    public ResponseEntity<Double> byCube(@RequestParam(name = "from") final Long city1,
                                        @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(city1, city2));
    }


}
