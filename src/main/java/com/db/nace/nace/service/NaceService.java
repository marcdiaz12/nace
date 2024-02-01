package com.db.nace.nace.service;

import com.db.nace.nace.domain.dto.NaceDTO;
import org.springframework.http.ResponseEntity;

public interface NaceService {
    public ResponseEntity<NaceDTO> getNaceById(Integer id);
    public ResponseEntity<NaceDTO> saveNace(NaceDTO naceDTO);
}
