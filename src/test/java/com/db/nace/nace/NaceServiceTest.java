package com.db.nace.nace;

import com.db.nace.nace.domain.dto.NaceDTO;
import com.db.nace.nace.domain.entity.Nace;
import com.db.nace.nace.repository.NaceRepository;
import com.db.nace.nace.service.NaceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static com.db.nace.nace.domain.transcoder.NaceDTOTranscoder.toDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NaceServiceTest {
	@Mock
	NaceRepository naceRepository;
	@InjectMocks
	private NaceServiceImpl naceService;
	private NaceDTO naceDTO;
	private Nace naceEntity;

	@BeforeEach
	void setup() {
		naceDTO = new NaceDTO(
				1,2, 'A',"parent",
				"description","includes",
				"alsoIncludes","rulings",
				"excludes","isic");
		naceEntity = new Nace(
				1,2, 'A',"parent",
				"description","includes",
				"alsoIncludes","rulings",
				"excludes","isic");
	}

	@Test
	public void saveNace_should_return_same_dto() {
		when(naceRepository.save(naceEntity)).thenReturn(naceEntity);
		ResponseEntity<NaceDTO> actual = naceService.saveNace(naceDTO);
		assertEquals(actual.getBody(),naceDTO);
	}

	@Test
	public void getNaceById_should_return_dto_if_exists(){
		when(naceRepository.findById(1)).thenReturn(Optional.of(naceEntity));
		ResponseEntity<NaceDTO> actual = naceService.getNaceById(1);
		assertEquals(actual.getBody(), toDTO(naceEntity));
	}

	@Test
	public void getNaceById_should_return_404_if_optional_is_empty(){
		when(naceRepository.findById(0)).thenReturn(Optional.empty());
		ResponseEntity<NaceDTO> actual = naceService.getNaceById(0);
		assertEquals(actual.getStatusCode(), HttpStatus.NOT_FOUND);
	}

}
