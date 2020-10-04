package com.westudy.msnotesresources.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.westudy.msnotesresources.dao.ClaseDAO;
import com.westudy.msnotesresources.dao.ComentarioDAO;
import com.westudy.msnotesresources.dao.RecursosDAO;
import com.westudy.msnotesresources.model.Clase;
import com.westudy.msnotesresources.model.Comentario;
import com.westudy.msnotesresources.model.Note;
import com.westudy.msnotesresources.model.Recursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("course/resources")
public class RecursosController {


    @Autowired
    private RecursosDAO recursosDAO;

    @Autowired
    private ClaseDAO claseDAO;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/get/{id}")
    public List<Recursos> listar(@PathVariable("id") Integer id){
        Optional<Clase> clase = claseDAO.findById(id);
        if(clase.isPresent()){
            Clase clasePresent = clase.get();
            List<Recursos> lista = clasePresent.getRecursos();
            for(Recursos c: lista){
                c.idClase = id;
            }
            return lista;
        }
        return null;
    }

    @PostMapping("/create")
    public ObjectNode guardar(@RequestBody Recursos recurso){
        ObjectNode res = mapper.createObjectNode();
        recurso.setClase(new Clase(recurso.idClase));
        try{
            recursosDAO.save(recurso);
        } catch (Exception e){
            res.put("res","false");
            res.put("message",e.getMessage());
            return res;
        }
        res.put("res","true");
        res.put("message","recurso creado correctamente");
	res.put("id", recurso.getId());
        return res;
    }

    @PutMapping("/edit/{id}")
    public ObjectNode actualizar(@PathVariable("id") Integer id, @RequestBody Recursos NuevoRecurso) {
        Optional<Recursos> recurso = recursosDAO.findById(id);
        ObjectNode res = mapper.createObjectNode();
        if(recurso.isPresent()){
            Recursos recursoExistente = recurso.get();
            recursoExistente.setContent(NuevoRecurso.getContent());
            recursosDAO.save(recursoExistente);
            res.put("res","true");
            res.put("message","recurso editado correctamente");
            return res;
        } else {
            res.put("res","false");
            res.put("message","No se encontro el recurso, por favor verificar");
            return res;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ObjectNode eliminar(@PathVariable("id") Integer id ){
        ObjectNode res = mapper.createObjectNode();
        if(recursosDAO.existsById(id)){
            recursosDAO.deleteById(id);
            res.put("res","true");
            res.put("message","Recurso eliminado correctamente");
        } else {
            res.put("res","false");
            res.put("message","No se encontro el recurso, por favor verificar");
        }
        return res;
    }

}
