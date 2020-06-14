/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.micda.pfe.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ma.micda.pfe.bean.CoursInscription;

/**
 *
 * @author Seo-info
 */
@Stateless
public class CoursInscriptionFacade extends AbstractFacade<CoursInscription> {

    @PersistenceContext(unitName = "pfe-v2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoursInscriptionFacade() {
        super(CoursInscription.class);
    }
    
}
