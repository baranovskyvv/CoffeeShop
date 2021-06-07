package by.softClub.CoffeeShop.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.time.LocalDate;
import java.time.LocalTime;

@FacesValidator("timeFromValidator")
public class TimeFromValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        LocalTime timeFrom = (LocalTime) o;
        ViewDateTime.timeFrom = timeFrom;
        FacesMessage message = new FacesMessage();
        if (timeFrom.isBefore(ViewDateTime.minTime) || timeFrom.isAfter(ViewDateTime.maxTime)) {
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Введите корректное время(время работы с 9 00 до 21 00)");
            message.setDetail("Введите корректное время(время работы с 9 00 до 21 00)");
            facesContext.addMessage("времяМинимальное", message);
            throw new ValidatorException(message);
        } else if (ViewDateTime.date.equals(LocalDate.now()) && timeFrom.isBefore(LocalTime.now())) {
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Введите корректное время");
            message.setDetail("Введите корректное время");
            facesContext.addMessage("времяМинимальное", message);
            throw new ValidatorException(message);
        }
    }
}

