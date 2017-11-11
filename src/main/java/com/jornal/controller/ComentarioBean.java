package com.jornal.controller;

import com.jornal.facede.ComentarioFacade;
import com.jornal.modell.Comentario;
import com.jornal.modell.Noticia;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ComentarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ComentarioFacade facade;

   @Inject
    private NoticiaBean noticiaBean;

    private Comentario novoComentario = new Comentario();

    public Comentario getNovoComentario() {
        return novoComentario;
    }

    public void adicionar() {
        Noticia noticia = noticiaBean.getNoticia();
        novoComentario.setNoticia(noticia);
        novoComentario.setDataPublicacao(new Date());
        facade.create(novoComentario);
        novoComentario = new Comentario();
    }

    public Comentario getComentario() {
        List<Comentario> comentarios = facade.findAll();
        Comentario comentario = null;
        if (comentarios.size() > 0) {
            comentario = comentarios.get(0);
        }
        return comentario;
    }

    public List<Comentario> getComentarios() {
        return facade.findAll();
    }

}
