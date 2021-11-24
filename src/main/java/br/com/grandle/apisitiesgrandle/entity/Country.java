package br.com.grandle.apisitiesgrandle.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project api-sities-grandle
 * Created by Leandro Saniago on 23/11/2021 - 16:33.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pais")
public class Country {

    @Id
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "nome_pt")
    private String portugueseName;
    @Column(name = "sigla")
    private String code;
    private Integer bacen;

}
