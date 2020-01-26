package guru.springframework.commands.validators;

import guru.springframework.commands.CustomerForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerFormValidator implements Validator {

  @Override
  public boolean supports(Class<?> aClass) {
    return CustomerForm.class.equals(aClass);
  }

  @Override
  public void validate(Object target, Errors errors) {

    CustomerForm customerForm = (CustomerForm) target;

    if (!customerForm.getPasswordText().equals(customerForm.getPasswordTextConf())) {
      errors.rejectValue("passwordText", "PaswordsDontMatch.customerForm.passwordText", "Passwords Don't Match");
      errors.rejectValue("passwordTextConf", "PaswordsDontMatch.customerForm.passwordTextConf", "Passwords Don't Match");
    }
  }
}
