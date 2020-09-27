package com.westudy.msnotesresources.dao;

import com.westudy.msnotesresources.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDAO extends JpaRepository<Note, Integer> {
}
