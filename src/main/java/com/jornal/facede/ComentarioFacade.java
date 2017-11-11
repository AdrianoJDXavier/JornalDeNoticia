/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jornal.facede;

import com.jornal.modell.Comentario;
import com.jornal.modell.Noticia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author alunoces
 */
@Stateless
public class ComentarioFacade extends AbstractFacade<Comentario> {

    @PersistenceContext(unitName = "com.jornal_JornalDeNoticias_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentarioFacade() {
        super(Comentario.class);
    }
    
    public List<Comentario> buscaComentarioPorNoticia(Noticia n) {
        TypedQuery<Comentario> query = em.createQuery("select c from Comentario c where c.noticia.id = :id", Comentario.class);
        query.setParameter("id", n.getId());
        return query.getResultList();
    }
    
}
