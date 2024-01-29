package com.db.nace.nace.controller;

import com.db.nace.nace.domain.dto.NaceDTO;
import com.db.nace.nace.domain.transcoder.NaceDTOTranscoder;
import com.db.nace.nace.service.NaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaceController {

    @Autowired
    NaceServiceImpl naceService;

    @GetMapping(value = "/getNaceDetails", produces = "application/json")
    public NaceDTO getNaceDetails(Integer id) {

        return NaceDTOTranscoder.toDTO(naceService.getNaceById(id));
    }

    @PostMapping(value = "/putNaceDetails", produces = "application/json")
    public NaceDTO getNaceDetails(NaceDTO naceDTO) {

        return NaceDTOTranscoder.toDTO(naceService.saveNace(naceDTO));
    }
}
