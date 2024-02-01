package com.db.nace.nace.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nace")
public class Nace {

    @Id
    private Integer id;

    private Integer level;

    private char code;

    private String parent;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String includes;

    @Column(name = "also_includes", length = 1000)
    private String alsoIncludes;

    @Column(length = 1000)
    private String rulings;

    @Column(length = 1000)
    private String excludes;

    private String isic;

}
