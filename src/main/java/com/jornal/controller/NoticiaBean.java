package com.jornal.controller;

import com.jornal.facede.NoticiaFacade;
import com.jornal.modell.Noticia;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class NoticiaBean  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private NoticiaFacade facade;
    
    private Noticia novaNoticia = new Noticia();
    
    public Noticia getNovaNotica() {
        return novaNoticia;
    }
    
    public void adicionar(){
        novaNoticia.setDataPublicacao(new Date());
        facade.create(novaNoticia);
        novaNoticia = new Noticia();
    }
    
    public Noticia getNoticia(){
        List<Noticia> noticias = facade.findAll();
        Noticia noticia = null;
        if (noticias.size()>0)
            noticia = noticias.get(0);
        return noticia;
    }
    
    public List<Noticia> getNoticias(){
        return facade.findAll();
    }
    
    public Noticia getNoticiaPorId(){
        Noticia noticia = facade.find(this);
        return noticia;
    }
    
    
    
}
