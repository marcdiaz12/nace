package com.db.nace.nace;

import com.db.nace.nace.domain.dto.NaceDTO;
import com.db.nace.nace.domain.entity.Nace;
import com.db.nace.nace.domain.transcoder.NaceDTOTranscoder;
import com.db.nace.nace.repository.NaceRepository;
import com.db.nace.nace.service.NaceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
		NaceDTO actual = NaceDTOTranscoder.toDTO(naceService.saveNace(naceDTO));
		assertEquals(actual,naceDTO);
	}

	//Failing Test
	//actualMessage="Cannot invoke "java.lang.Integer.intValue()" because "this.level" is null"
	@Test
	public void saveNace_should_throw_controlled_error_if_dto_is_empty(){
		NaceDTO emptyNaceDTO = new NaceDTO();
		Exception exception = assertThrows(NullPointerException.class,() -> {
			NaceDTOTranscoder.toDTO(naceService.saveNace(emptyNaceDTO));
		});
		String expectedMessage = "Cannot insert an empty NACE";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	//getNaceById
	@Test
	public void getNaceById_should_return_entity_if_exists(){
		when(naceRepository.findById(1)).thenReturn(Optional.of(naceEntity));
		Nace actual = naceService.getNaceById(1);
		assertEquals(actual, naceEntity);
	}

	//Failing Test
	//A ClassNotFoundException should be thrown at service level on .Optional.OrElseThrow()
	@Test
	public void getNaceById_throw_controlled_error_if_optional_is_empty(){
		when(naceRepository.findById(0)).thenReturn(Optional.empty());
		Exception exception = assertThrows(ClassNotFoundException.class,() -> {
			naceService.getNaceById(0);
				});
		String expectedMessage = "NACE was not found";
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

}
