package com.westudy.msnotesresources.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CLASE")
public class Clase {
    @Id
    @Column(name = "id_clase")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clase")
    private List<Note> notas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clase")
    private List<Recursos> recursos;


    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    @Column(name = "forum")
    private String forum;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
