/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.micda.pfe.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ma.micda.pfe.bean.NiveauDiffeculte;

/**
 *
 * @author Seo-info
 */
@Stateless
public class NiveauDiffeculteFacade extends AbstractFacade<NiveauDiffeculte> {

    @PersistenceContext(unitName = "pfe-v2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NiveauDiffeculteFacade() {
        super(NiveauDiffeculte.class);
    }
    
}
