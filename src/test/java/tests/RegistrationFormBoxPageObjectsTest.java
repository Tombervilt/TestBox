package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormBoxPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfullTest() {
        registrationPage
                .openPage()
                .setFirstName("Thomas")
                .setFirstLast("Anderson")
                .setEmail("neo@matrix.web")
                .setGender("Male")
                .setUserNumber("8800555353")
                .setDateOfBirth("13", "September", "1971");
        $("#subjectsInput").setValue("English").pressEnter();
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("image/test.png");
        $("#currentAddress").setValue("г. Н, ул. Пушкина, д. Колотушкина, кв. 101");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $("#submit").click();

        $("div[role=document]")
                .shouldHave(text("Thomas Anderson"))
                .shouldHave(text("neo@matrix.web"))
                .shouldHave(text("Male"))
                .shouldHave(text("8800555353"))
                .shouldHave(text("13 September,1971"))
                .shouldHave(text("English"))
                .shouldHave(text("Sports, Music"))
                .shouldHave(text("test.png"))
                .shouldHave(text("г. Н, ул. Пушкина, д. Колотушкина, кв. 101"))
                .shouldHave(text("Uttar Pradesh Agra"));
    }
}
