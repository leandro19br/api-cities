package br.com.grandle.apisitiesgrandle.repository;

import br.com.grandle.apisitiesgrandle.entity.City;
import br.com.grandle.apisitiesgrandle.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @project api-sities-grandle
 * Created by Leandro Saniago on 23/11/2021 - 16:45.
 */
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    Double distanceByPoints(Long city1, Long city2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(double x, double y, double x1, double y1);
}
