/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.micda.pfe.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ma.micda.pfe.bean.Fillier;
import ma.micda.pfe.bean.User;

/**
 *
 * @author Seo-info
 */
@Stateless
public class FillierFacade extends AbstractFacade<Fillier> {

    @PersistenceContext(unitName = "pfe-v2PU")
    private EntityManager em;
    
    public List<Fillier> findByParcourId(Long parcourId) {
        List<Fillier> filliers = em.createQuery("SELECT f FROM Fillier f WHERE f.parcours.id = '" + parcourId + "'").getResultList();
        return filliers;
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FillierFacade() {
        super(Fillier.class);
    }
    
}
