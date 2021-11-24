package br.com.grandle.apisitiesgrandle.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

/**
 * @project api-sities-grandle
 * Created by Leandro Saniago on 23/11/2021 - 16:33.
 * necessário utilizar uma API externa para ensinar ao Hibernate como utiliar um campo do tipo json utilizado no ddd
 */


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "State")
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb" , typeClass = JsonBinaryType.class)
})
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private Integer ibge;

    //varios estados pertencem a um pais
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country countryId;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd")
    private List<Integer> ddd;

}
