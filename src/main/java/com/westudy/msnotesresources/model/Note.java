package com.westudy.msnotesresources.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "NOTA")
public class Note {
    @Id
    @Column(name = "id_note")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "note")
    private List<Comentario> comentarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clase")
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

    public void setId(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
