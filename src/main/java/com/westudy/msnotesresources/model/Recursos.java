package com.westudy.msnotesresources.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "RESOURCE")
public class Recursos {
    @Id
    @Column(name = "id_recurso")
    @GeneratedValue(strategy = GenerationType.IDENTITY,  generator="native")
    private Integer id;

    @Transient
    public Integer idClase;

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clase")
    @JsonIgnore
    private Clase clase;

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

    @Column(name = "id_user")
    private String idUser;

    @Column(name = "content")
    private String content;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
