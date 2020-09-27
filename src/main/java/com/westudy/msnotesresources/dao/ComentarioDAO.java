package com.westudy.msnotesresources.dao;

import com.westudy.msnotesresources.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioDAO extends JpaRepository<Comentario, Integer> {
}
