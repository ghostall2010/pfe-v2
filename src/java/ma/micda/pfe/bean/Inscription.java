/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.micda.pfe.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Seo-info
 */
@Entity
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInscription;
    @ManyToOne
    private EtatInscription etatInscription;
    @ManyToOne
    private Fillier fillier;
    @ManyToOne
    private User user;
    


    public Inscription(Long id, Date dateInscription, EtatInscription etatInscription, Fillier fillier, User user) {
        this.id = id;
        this.dateInscription = dateInscription;
        this.etatInscription = etatInscription;
        this.fillier = fillier;
        this.user = user;
    }

    public Inscription() {
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public EtatInscription getEtatInscription() {
        return etatInscription;
    }

    public void setEtatInscription(EtatInscription etatInscription) {
        this.etatInscription = etatInscription;
    }

    public Fillier getFillier() {
        return fillier;
    }

    public void setFillier(Fillier fillier) {
        this.fillier = fillier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ma.micda.pfe.bean.Inscription[ id=" + id + " ]";
    }
    
}
