package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

   private SelenideElement
           firstNameInput = $("#firstName"),
           lastNameInput = $("#lastName"),
           emailInput = $("#userEmail"),
           genterWrapper = $("#genterWrapper"),
           userNameInput = $("#userNumber"),
           calendarInput = $("#dateOfBirthInput");

   CalendarComponent calendarComponent = new CalendarComponent();

   public RegistrationPage openPage() {
      open("/automation-practice-form");
      return this;
   }

   public RegistrationPage setFirstName(String value) {
      firstNameInput.setValue(value);
      return this;
   }

   public RegistrationPage setFirstLast(String value) {
      lastNameInput.setValue(value);
      return this;
   }

   public RegistrationPage setEmail(String value) {
      emailInput.setValue(value);
      return this;
   }

   public RegistrationPage setGender(String value) {
      genterWrapper.$(byText(value)).click();
      return this;
   }

   public RegistrationPage setUserNumber(String value) {
      userNameInput.setValue(value);
      return this;
   }

   public RegistrationPage setDateOfBirth(String day, String month, String year) {
      calendarInput.click();
      calendarComponent.setDate(day, month, year);
      return this;
   }
}