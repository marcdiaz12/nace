package com.db.nace.nace.repository;

import com.db.nace.nace.domain.dto.NaceDTO;
import com.db.nace.nace.domain.entity.Nace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface NaceRepository extends CrudRepository<Nace, Integer> {
    Optional<Nace> findById(Integer id);

    Nace save(Nace nace);
}
