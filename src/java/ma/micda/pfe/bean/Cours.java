/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.micda.pfe.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Seo-info
 */
@Entity
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String description;

    public Cours(Long id, String nom, String description, Module module, Double coeffission, NiveauDiffeculte niveauDiffeculte, EtatCours etatCours) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.module = module;
        this.coeffission = coeffission;
        this.niveauDiffeculte = niveauDiffeculte;
        this.etatCours = etatCours;
    }

    public Cours() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Double getCoeffission() {
        return coeffission;
    }

    public void setCoeffission(Double coeffission) {
        this.coeffission = coeffission;
    }

    public NiveauDiffeculte getNiveauDiffeculte() {
        return niveauDiffeculte;
    }

    public void setNiveauDiffeculte(NiveauDiffeculte niveauDiffeculte) {
        this.niveauDiffeculte = niveauDiffeculte;
    }

    public EtatCours getEtatCours() {
        return etatCours;
    }

    public void setEtatCours(EtatCours etatCours) {
        this.etatCours = etatCours;
    }
    
     
    
    
    @ManyToOne
    private Module module;
    private Double coeffission;
    @ManyToOne
    private NiveauDiffeculte niveauDiffeculte;
    @ManyToOne
    private EtatCours etatCours;

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
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ma.micda.pfe.bean.Cours[ id=" + id + " ]";
    }
    
}
