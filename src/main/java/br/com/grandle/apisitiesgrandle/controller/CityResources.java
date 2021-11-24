package br.com.grandle.apisitiesgrandle.controller;

import br.com.grandle.apisitiesgrandle.entity.City;
import br.com.grandle.apisitiesgrandle.entity.State;
import br.com.grandle.apisitiesgrandle.repository.CityRepository;
import br.com.grandle.apisitiesgrandle.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project api-sities-grandle
 * Created by Leandro Saniago on 23/11/2021 - 16:28.
 */
@RestController
@RequestMapping("/cities")
public class CityResources {

    private CityRepository repository;

    @Autowired
    public CityResources(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<City> countries(Pageable pageable){
        return repository.findAll(pageable);
    }


}
