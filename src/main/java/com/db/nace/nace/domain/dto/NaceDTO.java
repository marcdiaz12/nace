package com.db.nace.nace.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

public class NaceDTO {

    //NoArgsConstructor
    public NaceDTO() {}

    //AllArgsConstructor
    public NaceDTO(Integer id, int level, char code, String parent, String description, String includes, String alsoIncludes, String rulings, String excludes, String isic) {
        this.order = id;
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

    @ApiModelProperty(position = 0, notes = "Order")
    @NotNull
    @NotBlank
    @Max(999_999)
    @Schema(example = "398481")
    private Integer order;
    @ApiModelProperty(position = 1, notes = "Level")
     @Schema(example = "1")
    private Integer level;
    @ApiModelProperty(position = 2, notes = "Code")
    @Size(max = 1)
    @Schema(example = "A")
    private char code;
    @ApiModelProperty(position = 3, notes = "Parent")
    @Size(max = 1000)
    @Schema(example = "")
    private String parent;
    @ApiModelProperty(position = 4, notes = "Description")
    @Size(max = 1000)
    @Schema(example = "AGRICULTURE, FORESTRY AND FISHING")
    private String description;
    @ApiModelProperty(position = 5, notes = "This item includes")
    @Size(max = 1000)
    @Schema(example = "This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.")
    private String includes;
    @ApiModelProperty(position = 6, notes = "This item also includes")
    @Size(max = 1000)
    @Schema(example = "")
    private String alsoIncludes;
    @ApiModelProperty(position = 7, notes = "Rulings")
    @Size(max = 1000)
    @Schema(example = "")
    private String rulings;
    @ApiModelProperty(position = 8, notes = "This item excludes")
    @Size(max = 1000)
    @Schema(example = "Agricultural activities exclude any subsequent processing of the agricultural products (classified under divisions 10 and 11 (Manufacture of food products and beverages) and division 12 (Manufacture of tobacco products)), beyond that needed to prepare them for the primary markets. The preparation of products for the primary markets is included here.")
    private String excludes;
    @ApiModelProperty(position = 9, notes = "Reference to ISIC Rev.4")
    @Size(max = 1000)
    @Schema(example = "1")
    private String isic;

    //Getters and Setters
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
        if (!(o instanceof NaceDTO naceDTO)) return false;
        return getCode() == naceDTO.getCode() && Objects.equals(getOrder(), naceDTO.getOrder()) && Objects.equals(getLevel(), naceDTO.getLevel()) && Objects.equals(getParent(), naceDTO.getParent()) && Objects.equals(getDescription(), naceDTO.getDescription()) && Objects.equals(getIncludes(), naceDTO.getIncludes()) && Objects.equals(getAlsoIncludes(), naceDTO.getAlsoIncludes()) && Objects.equals(getRulings(), naceDTO.getRulings()) && Objects.equals(getExcludes(), naceDTO.getExcludes()) && Objects.equals(getIsic(), naceDTO.getIsic());
    }
}
