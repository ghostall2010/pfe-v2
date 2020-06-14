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
public class CoursInscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInscription;
    @ManyToOne
    private Cours cours;
    @ManyToOne
    private Inscription inscription;
    @ManyToOne
    private ModuleInscription moduleInscription;

    public CoursInscription(Long id, Date dateInscription, Cours cours, Inscription inscription, ModuleInscription moduleInscription) {
        this.id = id;
        this.dateInscription = dateInscription;
        this.cours = cours;
        this.inscription = inscription;
        this.moduleInscription = moduleInscription;
    }

    public CoursInscription() {
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public ModuleInscription getModuleInscription() {
        return moduleInscription;
    }

    public void setModuleInscription(ModuleInscription moduleInscription) {
        this.moduleInscription = moduleInscription;
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
        if (!(object instanceof CoursInscription)) {
            return false;
        }
        CoursInscription other = (CoursInscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   

}
