package com.db.nace.nace.service;

import com.db.nace.nace.domain.dto.NaceDTO;
import com.db.nace.nace.domain.entity.Nace;
import com.db.nace.nace.domain.transcoder.NaceDTOTranscoder;
import com.db.nace.nace.repository.NaceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NaceServiceImpl implements NaceService {
    private final NaceRepository naceRepository;
    public NaceServiceImpl(NaceRepository naceRepository) {
        this.naceRepository = naceRepository;
    }

    public ResponseEntity<NaceDTO> getNaceById(Integer id){
        Optional<Nace> nace = naceRepository.findById(id);
        return nace.map(n -> ResponseEntity.ok().body(NaceDTOTranscoder.toDTO(nace.get())))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    public ResponseEntity<NaceDTO> saveNace(NaceDTO naceDTO) {
        Nace nace = naceRepository.save(NaceDTOTranscoder.toEntity(naceDTO));
        return ResponseEntity.ok().body(NaceDTOTranscoder.toDTO(nace));
    }
}
