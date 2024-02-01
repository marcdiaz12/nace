package com.db.nace.nace.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NaceDTO {

    @ApiModelProperty(position = 0, notes = "Order")
    @NotBlank
    @Max(999_999)
    @Schema(example = "398481")
    private Integer order;

    @ApiModelProperty(position = 1, notes = "Level")
    @Schema(example = "1")
    @NotNull
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

}
