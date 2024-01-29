package com.db.nace.nace.domain.transcoder;

import com.db.nace.nace.domain.dto.NaceDTO;
import com.db.nace.nace.domain.entity.Nace;

public class NaceDTOTranscoder {
    public static NaceDTO toDTO(Nace nace) {
        NaceDTO naceDTO = new NaceDTO();
        naceDTO.setOrder(nace.getId());
        naceDTO.setLevel(nace.getLevel());
        naceDTO.setCode(nace.getCode());
        naceDTO.setParent(nace.getParent());
        naceDTO.setDescription(nace.getDescription());
        naceDTO.setIncludes(nace.getIncludes());
        naceDTO.setAlsoIncludes(nace.getAlsoIncludes());
        naceDTO.setRulings(nace.getRulings());
        naceDTO.setExcludes(nace.getExcludes());
        naceDTO.setIsic(nace.getIsic());
        return naceDTO;
    }

    public static Nace toEntity(NaceDTO naceDTO) {
        Nace nace = new Nace();
        nace.setId(naceDTO.getOrder());
        nace.setLevel(naceDTO.getLevel());
        nace.setCode(naceDTO.getCode());
        nace.setParent(naceDTO.getParent());
        nace.setDescription(naceDTO.getDescription());
        nace.setIncludes(naceDTO.getIncludes());
        nace.setAlsoIncludes(naceDTO.getAlsoIncludes());
        nace.setRulings(naceDTO.getRulings());
        nace.setExcludes(naceDTO.getExcludes());
        nace.setIsic(naceDTO.getIsic());
        return nace;
    }
}
