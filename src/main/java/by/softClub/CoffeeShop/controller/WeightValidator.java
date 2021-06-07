package by.softClub.CoffeeShop.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("weightValidator")
public class WeightValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        int weight = Integer.parseInt(o.toString());
        if (weight < 1 || weight > 5000) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Вес должен быть больше 0 и меньше 5 000 грамм.");
            message.setDetail("Вес должен быть больше 0 и меньше 5 000 грамм.");
            facesContext.addMessage("вес", message);
            throw new ValidatorException(message);
        }

    }
}
