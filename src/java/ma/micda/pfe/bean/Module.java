/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.micda.pfe.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Seo-info
 */
@Entity
public class Module implements Serializable {

    @OneToMany(mappedBy = "module")
    private List<Cours> courss;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String description;

    public Module(List<Cours> courss, Long id, String nom, String description, Fillier fillier, NiveauDiffeculte niveauDiffeculte) {
        this.courss = courss;
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.fillier = fillier;
        this.niveauDiffeculte = niveauDiffeculte;
    }

    public Module() {
    }

    public List<Cours> getCourss() {
        return courss;
    }

    public void setCourss(List<Cours> courss) {
        this.courss = courss;
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

    public Fillier getFillier() {
        return fillier;
    }

    public void setFillier(Fillier fillier) {
        this.fillier = fillier;
    }

    public NiveauDiffeculte getNiveauDiffeculte() {
        return niveauDiffeculte;
    }

    public void setNiveauDiffeculte(NiveauDiffeculte niveauDiffeculte) {
        this.niveauDiffeculte = niveauDiffeculte;
    }
    
    
    @ManyToOne
    private Fillier fillier;
    @ManyToOne
    private NiveauDiffeculte niveauDiffeculte;
    
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
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ma.micda.pfe.bean.Module[ id=" + id + " ]";
    }
    
}
