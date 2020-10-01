package com.westudy.msnotesresources.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.westudy.msnotesresources.dao.ComentarioDAO;
import com.westudy.msnotesresources.model.Comentario;
import com.westudy.msnotesresources.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("course/notes/comment")
public class ComentariosController {

    @Autowired
    private ComentarioDAO comentarioDAO;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping("/create")
    public ObjectNode guardar(@RequestBody Comentario comentario){
        ObjectNode res = mapper.createObjectNode();
        comentario.setNote(new Note(comentario.idNote));
        try{
            comentarioDAO.save(comentario);
        } catch (Exception e){
            res.put("res","false");
            res.put("message",e.getMessage());
            return res;
        }
        res.put("res","true");
        res.put("message","comentario guardado correctamente");
        return res;
    }

    @PutMapping("/edit/{id}")
    public ObjectNode actualizar(@PathVariable("id") Integer id, @RequestBody Comentario Nuevocomentario) {
        Optional<Comentario> comentario = comentarioDAO.findById(id);
        ObjectNode res = mapper.createObjectNode();
        if(comentario.isPresent()){
            Comentario personaExistente = comentario.get();
            personaExistente.setContent(Nuevocomentario.getContent());
            comentarioDAO.save(personaExistente);
            res.put("res","true");
            res.put("message","Comentario editado correctamente");
            return res;
        } else {
            res.put("res","false");
            res.put("message","No se encontro el comentario, por favor verificar");
            return res;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ObjectNode eliminar(@PathVariable("id") Integer id ){
        ObjectNode res = mapper.createObjectNode();
        if(comentarioDAO.existsById(id)){
            comentarioDAO.deleteById(id);
            res.put("res","true");
            res.put("message","Comentario eliminada correctamente");
        } else {
            res.put("res","false");
            res.put("message","No se encontro el comentario, por favor verificar");
        }
        return res;
    }

}
