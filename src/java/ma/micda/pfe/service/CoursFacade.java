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
import ma.micda.pfe.bean.Cours;

/**
 *
 * @author Seo-info
 */
@Stateless
public class CoursFacade extends AbstractFacade<Cours> {

    @PersistenceContext(unitName = "pfe-v2PU")
    private EntityManager em;

    public List<Cours> findByModuleId(Long moduleId) {
        List<Cours> courses = em.createQuery("SELECT c FROM Cours c WHERE c.module.id = '" + moduleId + "'").getResultList();
        return courses;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoursFacade() {
        super(Cours.class);
    }
    
}
