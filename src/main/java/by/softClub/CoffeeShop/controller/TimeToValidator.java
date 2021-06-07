package by.softClub.CoffeeShop.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.time.LocalDate;
import java.time.LocalTime;

@FacesValidator("timeToValidator")
public class TimeToValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        LocalTime timeTo = (LocalTime) o;
        FacesMessage message = new FacesMessage();
        if ((ViewDateTime.date.equals(LocalDate.now()) && timeTo.isBefore(ViewDateTime.timeFrom)) ||
                ViewDateTime.timeFrom.isAfter(timeTo)) {
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Введите корректное время");
            message.setDetail("Введите корректное время");
            facesContext.addMessage("времяМинимальное", message);
            throw new ValidatorException(message);
        }
        if (timeTo.isBefore(ViewDateTime.minTime) || timeTo.isAfter(ViewDateTime.maxTime)) {
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Введите корректное время(время работы магазина с 9 00 -21 00)");
            message.setDetail("Введите корректное время(время работы магазина с 9 00 -21 00)");
            facesContext.addMessage("времяМинимальное", message);
            throw new ValidatorException(message);
        }
    }
}
