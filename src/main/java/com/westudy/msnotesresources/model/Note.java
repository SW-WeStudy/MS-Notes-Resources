package com.westudy.msnotesresources.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "NOTE")
public class    Note {

    public Note(){}
    public Note(Integer id){
        this.id = id;
    }

    @Id
    @Column(name = "id_note", nullable = false)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "note")
    private List<Comentario> comentarios;

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Clase clase;

    @Column(name = "id_user")
    private String idUser;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Column(name = "content")
    private String content;


    @Column(name = "score")
    private Integer score;

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }
}
