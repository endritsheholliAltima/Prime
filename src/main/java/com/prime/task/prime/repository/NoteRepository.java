package com.prime.task.prime.repository;

import com.prime.task.prime.model.NoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteModel, Long> {

}
