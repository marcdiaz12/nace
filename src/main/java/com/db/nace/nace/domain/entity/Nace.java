package com.db.nace.nace.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import java.util.Objects;

@Entity
@Table(name = "nace")
public class Nace {
    //NoArgsConstructor
    public Nace() {}

    //AllArgsConstructor
    public Nace(Integer id, int level, char code, String parent, String description, String includes, String alsoIncludes, String rulings, String excludes, String isic) {
        this.id = id;
        this.level = level;
        this.code = code;
        this.parent = parent;
        this.description = description;
        this.includes = includes;
        this.alsoIncludes = alsoIncludes;
        this.rulings = rulings;
        this.excludes = excludes;
        this.isic = isic;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID"
    )
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

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIncludes() {
        return includes;
    }

    public void setIncludes(String includes) {
        this.includes = includes;
    }

    public String getAlsoIncludes() {
        return alsoIncludes;
    }

    public void setAlsoIncludes(String alsoIncludes) {
        this.alsoIncludes = alsoIncludes;
    }

    public String getRulings() {
        return rulings;
    }

    public void setRulings(String rulings) {
        this.rulings = rulings;
    }

    public String getExcludes() {
        return excludes;
    }

    public void setExcludes(String excludes) {
        this.excludes = excludes;
    }

    public String getIsic() {
        return isic;
    }

    public void setIsic(String isic) {
        this.isic = isic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nace nace)) return false;
        return getLevel() == nace.getLevel() && getCode() == nace.getCode() && Objects.equals(getId(), nace.getId()) && Objects.equals(getParent(), nace.getParent()) && Objects.equals(getDescription(), nace.getDescription()) && Objects.equals(getIncludes(), nace.getIncludes()) && Objects.equals(getAlsoIncludes(), nace.getAlsoIncludes()) && Objects.equals(getRulings(), nace.getRulings()) && Objects.equals(getExcludes(), nace.getExcludes()) && Objects.equals(getIsic(), nace.getIsic());
    }
}
