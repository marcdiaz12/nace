package com.db.nace.nace.service;

import com.db.nace.nace.domain.dto.NaceDTO;
import com.db.nace.nace.domain.entity.Nace;
import com.db.nace.nace.repository.NaceRepository;

public interface NaceService {
    public Nace getNaceById(Integer id);
    public Nace saveNace(NaceDTO naceDTO);
}
