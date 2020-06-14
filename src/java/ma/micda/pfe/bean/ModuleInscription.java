/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.micda.pfe.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Seo-info
 */
@Entity
public class ModuleInscription implements Serializable {

    @OneToMany(mappedBy = "moduleInscription")
    private List<CoursInscription> coursInscriptions;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Module module;
    @ManyToOne
    private Inscription inscription;
    @ManyToOne
    private EtatModule etatModule;
    private Double note;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInscription;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinalisation;

    public ModuleInscription(List<CoursInscription> coursInscriptions, Long id, Module module, Inscription inscription, EtatModule etatModule, Double note, Date dateInscription, Date dateFinalisation) {
        this.coursInscriptions = coursInscriptions;
        this.id = id;
        this.module = module;
        this.inscription = inscription;
        this.etatModule = etatModule;
        this.note = note;
        this.dateInscription = dateInscription;
        this.dateFinalisation = dateFinalisation;
    }

    public ModuleInscription() {
    }

    public List<CoursInscription> getCoursInscriptions() {
        return coursInscriptions;
    }

    public void setCoursInscriptions(List<CoursInscription> coursInscriptions) {
        this.coursInscriptions = coursInscriptions;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public EtatModule getEtatModule() {
        return etatModule;
    }

    public void setEtatModule(EtatModule etatModule) {
        this.etatModule = etatModule;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDateFinalisation() {
        return dateFinalisation;
    }

    public void setDateFinalisation(Date dateFinalisation) {
        this.dateFinalisation = dateFinalisation;
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
        if (!(object instanceof ModuleInscription)) {
            return false;
        }
        ModuleInscription other = (ModuleInscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ma.micda.pfe.bean.ModuleInscription[ id=" + id + " ]";
    }
    
}
