package ma.micda.pfe.controller;

import ma.micda.pfe.bean.Parcours;
import ma.micda.pfe.controller.util.JsfUtil;
import ma.micda.pfe.controller.util.JsfUtil.PersistAction;
import ma.micda.pfe.service.ParcoursFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ma.micda.pfe.bean.Fillier;

@Named("parcoursController")
@SessionScoped
public class ParcoursController implements Serializable {

    @EJB
    private ma.micda.pfe.service.ParcoursFacade ejbFacade;
     @EJB
    private ma.micda.pfe.service.FillierFacade fillierFacade;
    private List<Parcours> items = null;
    private Parcours selected;
    private List<Fillier> filliers = new ArrayList<>();
    
    
    
    public void findByParcoursId(Long id){
         filliers = fillierFacade.findByParcourId(id);
    }
    public ParcoursController() {
    }

    public Parcours getSelected() {
        return selected;
    }

    public void setSelected(Parcours selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ParcoursFacade getFacade() {
        return ejbFacade;
    }

    public Parcours prepareCreate() {
        selected = new Parcours();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ParcoursCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ParcoursUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ParcoursDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Fillier> getFilliers() {
        return filliers;
    }

    public void setFilliers(List<Fillier> filliers) {
        this.filliers = filliers;
    }

    public List<Parcours> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Parcours getParcours(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Parcours> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Parcours> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Parcours.class)
    public static class ParcoursControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ParcoursController controller = (ParcoursController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "parcoursController");
            return controller.getParcours(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Parcours) {
                Parcours o = (Parcours) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Parcours.class.getName()});
                return null;
            }
        }

    }

}
