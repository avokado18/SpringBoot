package com.cinimex.myProject.repository;

import com.cinimex.myProject.model.Word;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {

    @Query(value = "SELECT t FROM Word t WHERE priority = ?1 ORDER BY random()")
    List<Word> findLimited(Integer prior, Pageable pageable);
}
