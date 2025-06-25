package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormBoxPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfullTest() {
        registrationPage
                .openPage()
                .setFirstName("Thomas")
                .setLastName("Anderson")
                .setEmail("neo@matrix.web")
                .setGender("Male")
                .setUserNumber("8800555353")
                .setDateOfBirth("13", "September", "1971")
                .setSubject("English")
                .setSubject("Hindi")
                .setSubject("Arts")
                .setHobbies("Sports")
                .setHobbies("Music")
                .setPicture("image/test.png")
                .setAdress("г. Н, ул. Пушкина, д. Колотушкина, кв. 101")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .getSubmit()

                //Проверка введенных данных
                .submitFormComponent("Student Name", "Thomas Anderson")
                .submitFormComponent("Student Email", "neo@matrix.web")
                .submitFormComponent("Gender", "Male")
                .submitFormComponent("Mobile", "8800555353")
                .submitFormComponent("Date of Birth", "13 September,1971")
                .submitFormComponent("Subjects", "English, Hindi, Arts")
                .submitFormComponent("Hobbies", "Sports, Music")
                .submitFormComponent("Picture", "test.png")
                .submitFormComponent("Address", "г. Н, ул. Пушкина, д. Колотушкина, кв. 101")
                .submitFormComponent("State and City", "Uttar Pradesh Agra");



    }
    @Test
    //Проверка только обязательных полей
    void minimalValueTest() {
        registrationPage
                .openPage()
                .setFirstName("Papa")
                .setLastName("John's")
                .setGender("Male")
                .setUserNumber("9031282097")
                .getSubmit()

        //Проверка введенных данных
                .submitFormComponent("Student Name", "Papa John's")
                .submitFormComponent("Gender", "Male")
                .submitFormComponent("Mobile", "9031282097");
    }

    @Test
    //Негативный тест без имени
    void negativeFirstNameTest() {
        registrationPage
                .openPage()
                .setLastName("John's")
                .setGender("Male")
                .setUserNumber("9031282097")
                .getSubmit()
                .submitFormHide();
    }
    @Test
        //Негативный тест без фамилии
    void negativeLastNameTest() {
        registrationPage
                .openPage()
                .setFirstName("Papa")
                .setGender("Male")
                .setUserNumber("9031282097")
                .getSubmit()
                .submitFormHide();
    }
    @Test
        //Негативный тест без гендера
    void negativeGenderTest() {
        registrationPage
                .openPage()
                .setFirstName("Papa")
                .setLastName("John's")
                .setUserNumber("9031282097")
                .getSubmit()
                .submitFormHide();
    }
    @Test
        //Негативный тест без номера
    void negativeUserNumberTest() {
        registrationPage
                .openPage()
                .setFirstName("Papa")
                .setLastName("John's")
                .setGender("Male")
                .getSubmit()
                .submitFormHide();
    }
}
