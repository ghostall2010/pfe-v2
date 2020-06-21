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
import ma.micda.pfe.bean.User;

/**
 *
 * @author Seo-info
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "pfe-v2PU")
    private EntityManager em;

    public int seConnecter(User user) {
        User loadedUser = findByEmail(user.getEmail());
        if (loadedUser == null) {
            return -1;
        } else if (!user.getMotDePasse().equals(loadedUser.getMotDePasse())) {
            return -2;
        } else {
            return 1;
        }
    }
    public List<User> findByCriteria(String nom, String prenom, String email){
    String query=initQuery();
    query +=addConstraintLike("nom", nom);
    query +=addConstraintLike("prenom", prenom);
    query +=addConstraintLike("email", email);
        System.out.println("query = " + query);
    return findMultiple(query);
}
    public User findByEmail(String email) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email = '" + email + "'").getResultList();
        if (users == null || users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

}
