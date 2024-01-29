package com.db.nace.nace.service;

import com.db.nace.nace.domain.dto.NaceDTO;
import com.db.nace.nace.domain.entity.Nace;
import com.db.nace.nace.domain.transcoder.NaceDTOTranscoder;
import com.db.nace.nace.repository.NaceRepository;
import org.springframework.stereotype.Service;

@Service
public class NaceServiceImpl implements NaceService {
    private final NaceRepository naceRepository;
    public NaceServiceImpl(NaceRepository naceRepository) {
        this.naceRepository = naceRepository;
    }

    public Nace getNaceById(Integer id){
        return naceRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Nace saveNace(NaceDTO naceDTO) {
        return naceRepository.save(NaceDTOTranscoder.toEntity(naceDTO));
    }
}
