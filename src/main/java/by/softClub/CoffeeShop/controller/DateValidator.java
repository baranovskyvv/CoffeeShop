package by.softClub.CoffeeShop.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.time.LocalDate;

@FacesValidator("dateValidator")
public class DateValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        LocalDate date=(LocalDate)o;
        ViewDateTime.date=date;
        if(date.isBefore(LocalDate.now())){
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Введенная дата некорректна(раньше реального времени)");
            message.setDetail("Введенная дата некорректна(раньше реального времени)");
            facesContext.addMessage("вес", message);
            throw new ValidatorException(message);
        }
    }
}
