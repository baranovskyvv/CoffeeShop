package by.softClub.CoffeeShop.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("phoneValidator")
public class PhoneValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String phone = o.toString();
        Pattern pattern = Pattern.compile("^\\+375\\((17|29|33|44|25)\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$");
        Matcher matcher = pattern.matcher(phone);
       if(!matcher.matches()){
           FacesMessage message = new FacesMessage();
           message.setSeverity(FacesMessage.SEVERITY_ERROR);
           message.setSummary("Неверно введен номер телефона.");
           message.setDetail("Неверно введен номер телефона.");
           facesContext.addMessage("телефон", message);
           throw new ValidatorException(message);
       }
    }
}
