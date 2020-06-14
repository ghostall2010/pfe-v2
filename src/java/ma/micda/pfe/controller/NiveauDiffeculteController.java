package ma.micda.pfe.controller;

import ma.micda.pfe.bean.NiveauDiffeculte;
import ma.micda.pfe.controller.util.JsfUtil;
import ma.micda.pfe.controller.util.JsfUtil.PersistAction;
import ma.micda.pfe.service.NiveauDiffeculteFacade;

import java.io.Serializable;
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

@Named("niveauDiffeculteController")
@SessionScoped
public class NiveauDiffeculteController implements Serializable {

    @EJB
    private ma.micda.pfe.service.NiveauDiffeculteFacade ejbFacade;
    private List<NiveauDiffeculte> items = null;
    private NiveauDiffeculte selected;

    public NiveauDiffeculteController() {
    }

    public NiveauDiffeculte getSelected() {
        return selected;
    }

    public void setSelected(NiveauDiffeculte selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private NiveauDiffeculteFacade getFacade() {
        return ejbFacade;
    }

    public NiveauDiffeculte prepareCreate() {
        selected = new NiveauDiffeculte();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("NiveauDiffeculteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("NiveauDiffeculteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("NiveauDiffeculteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<NiveauDiffeculte> getItems() {
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

    public NiveauDiffeculte getNiveauDiffeculte(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<NiveauDiffeculte> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<NiveauDiffeculte> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = NiveauDiffeculte.class)
    public static class NiveauDiffeculteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NiveauDiffeculteController controller = (NiveauDiffeculteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "niveauDiffeculteController");
            return controller.getNiveauDiffeculte(getKey(value));
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
            if (object instanceof NiveauDiffeculte) {
                NiveauDiffeculte o = (NiveauDiffeculte) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NiveauDiffeculte.class.getName()});
                return null;
            }
        }

    }

}
