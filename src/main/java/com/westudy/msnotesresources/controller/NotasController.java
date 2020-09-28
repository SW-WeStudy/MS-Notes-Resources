package com.westudy.msnotesresources.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.westudy.msnotesresources.dao.ClaseDAO;
import com.westudy.msnotesresources.dao.ComentarioDAO;
import com.westudy.msnotesresources.dao.NoteDAO;
import com.westudy.msnotesresources.model.Clase;
import com.westudy.msnotesresources.model.Comentario;
import com.westudy.msnotesresources.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("course/notes")
public class NotasController {

    @Autowired
    private NoteDAO noteDAO;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/getcomments/{id}")
    public List<Comentario> listar(@PathVariable("id") Integer id){
        Optional<Note> nota = noteDAO.findById(id);
        if(nota.isPresent()){
            Note notePresent = nota.get();
            List<Comentario> lista = notePresent.getComentarios();
            for(Comentario c: lista){
                c.idNote = id;
            }
            return lista;

        }
        return null;
    }
}
