package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.SubmitFormComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

   private SelenideElement
           firstNameInput = $("#firstName"),
           lastNameInput = $("#lastName"),
           emailInput = $("#userEmail"),
           genderWrapper = $("#genterWrapper"),
           userNameInput = $("#userNumber"),
           calendarInput = $("#dateOfBirthInput"),
           subjectsInput = $("#subjectsInput"),
           hobbiesWrapper = $("#hobbiesWrapper"),
           pictureInput = $("#uploadPicture"),
           adressInput = $("#currentAddress"),
           stateInput = $("#react-select-3-input"),
           cityInput = $("#react-select-4-input"),
           submitButton = $("#submit");





   CalendarComponent calendarComponent = new CalendarComponent();
   SubmitFormComponent submitFormComponent = new SubmitFormComponent();

   public RegistrationPage openPage() {
      open("/automation-practice-form");
      return this;
   }

   public RegistrationPage setFirstName(String value) {
      firstNameInput.setValue(value);
      return this;
   }

   public RegistrationPage setLastName(String value) {
      lastNameInput.setValue(value);
      return this;
   }

   public RegistrationPage setEmail(String value) {
      emailInput.setValue(value);
      return this;
   }

   public RegistrationPage setGender(String value) {
      genderWrapper.$(byText(value)).click();
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

   public RegistrationPage setSubject(String value) {
      subjectsInput.setValue(value).pressEnter();
      return this;
   }

   public RegistrationPage setHobbies(String value) {
      hobbiesWrapper.$(byText(value)).click();
      return this;
   }

   public RegistrationPage setPicture(String filePath) {
      pictureInput.uploadFromClasspath(filePath);
      return this;
   }

   public RegistrationPage setAdress(String value) {
      adressInput.setValue(value);
      return this;
   }

   public RegistrationPage setState(String value) {
      stateInput.setValue(value).pressEnter();
      return this;
   }

   public RegistrationPage setCity(String value) {
      cityInput.setValue(value).pressEnter();
      return this;
   }

   public RegistrationPage getSubmit() {
      submitButton.click();
      return this;
   }

   public RegistrationPage submitFormComponent(String fieldName, String value) {
      submitFormComponent.checkResultForm(fieldName, value);
      return this;
   }

   public RegistrationPage submitFormHide() {
      submitFormComponent.resultFormNotVisible();
      return this;
   }
}