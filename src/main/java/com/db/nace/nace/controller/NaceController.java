package com.db.nace.nace.controller;

import com.db.nace.nace.domain.dto.NaceDTO;
import com.db.nace.nace.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaceController {

    @Autowired
    NaceService naceService;

    @GetMapping(value = "/getNaceDetails", produces = "application/json")
    public ResponseEntity<NaceDTO> getNaceDetails(Integer id) {

        return naceService.getNaceById(id);
    }

    @PutMapping(value = "/putNaceDetails", produces = "application/json")
    public ResponseEntity<NaceDTO> putNaceDetails(NaceDTO naceDTO) {

        return naceService.saveNace(naceDTO);
    }
}
