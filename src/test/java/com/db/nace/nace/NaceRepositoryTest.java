package com.db.nace.nace;

import com.db.nace.nace.domain.entity.Nace;
import com.db.nace.nace.repository.NaceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(classes = NaceApplication.class)
public class NaceRepositoryTest {
    @Autowired
    private NaceRepository naceRepository;
    private Nace nace;
    @Before
    public void setup() {
        nace = new Nace(
                1,2, 'A',"parent",
                "description","includes",
                "alsoIncludes","rulings",
                "excludes","isic");
    }

    @Test
    public void save_should_return_same_entity() {
        Nace actual = naceRepository.save(nace);
        assertEquals(actual,nace);
    }

    //Failing test
    //There should be some other mandatory fields aside from id
    @Test
    public void save_should_return_error_when_only_id_is_present() {
        Nace newNace = new Nace();
        newNace.setId(1);
        assertThrows(NullPointerException.class,() -> {
            naceRepository.save(newNace);
        });
    }

    //findById
    @Test
    public void findById_should_return_a_previously_saved_entity() {
        Nace expected = naceRepository.save(nace);
        Optional<Nace> naceOptional = naceRepository.findById(expected.getId());
        Nace actual = naceOptional.orElseGet(Nace::new);
        assertEquals(actual,expected);
    }
    @Test
    public void findById_should_return_empty_optional_when_entity_not_found() {
        Optional<Nace> actual = naceRepository.findById(1234123);
        assertFalse(actual.isPresent());
    }

}
