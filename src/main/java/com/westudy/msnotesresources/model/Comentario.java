package com.westudy.msnotesresources.model;

import javax.persistence.*;

@Entity
@Table(name = "COMENTARIO")
public class Comentario {

    @Id
    @Column(name = "id_comentario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_note")
    private Note note;

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

    @Column(name = "content")
    private String content;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
