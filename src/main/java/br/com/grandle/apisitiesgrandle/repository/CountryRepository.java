package br.com.grandle.apisitiesgrandle.repository;

import br.com.grandle.apisitiesgrandle.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project api-sities-grandle
 * Created by Leandro Saniago on 23/11/2021 - 16:45.
 */
public interface CountryRepository extends JpaRepository<Country, Long> {

}
