package br.com.grandle.apisitiesgrandle.controller;

import br.com.grandle.apisitiesgrandle.entity.Country;
import br.com.grandle.apisitiesgrandle.entity.State;
import br.com.grandle.apisitiesgrandle.repository.CountryRepository;
import br.com.grandle.apisitiesgrandle.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @project api-sities-grandle
 * Created by Leandro Saniago on 23/11/2021 - 16:28.
 */
@RestController
@RequestMapping("/states")
public class StateResources {

    private StateRepository repository;

    @Autowired
    public StateResources(StateRepository repository) {
        this.repository = repository;
    }

    //utilizando Pageable do Spring vc pode utilizar paginação e ordenação e retorna uma Page
    //http://localhost:8080/countries?page=0&size=10&sort=name,asc utiliza parâmetros convenção do Spring
    @GetMapping
    public Page<State> countries(Pageable pageable){

        return repository.findAll(pageable);
    }

/*    @GetMapping("/{id}")
    public ResponseEntity <Country> getOne(@PathVariable Long id){
        Optional<Country> byId = repository.findById(id);
        if (byId.isPresent()){

            return ResponseEntity.ok().body(byId.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }*/

}
