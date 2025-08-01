package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormBoxFakerTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfullTest() {
        Faker faker = new Faker(new Locale("ru"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.name().fullName();


        open("/automation-practice-form");
        $("#firstName").setValue("Thomas");
        $("#lastName").setValue("Anderson");
        $("#userEmail").setValue("neo@matrix.web");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8800555353");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1971");
        $("div[aria-label='Choose Monday, September 13th, 1971']").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("image/test.png");
        $("#currentAddress").setValue("г. Н, ул. Пушкина, д. Колотушкина, кв. 101");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $("#submit").click();

        $("div[role=document]").shouldHave(text("Thomas Anderson")).shouldHave(text("neo@matrix.web")).shouldHave(text("Male"))
                .shouldHave(text("8800555353")).shouldHave(text("13 September,1971")).shouldHave(text("English")).shouldHave(text("Sports, Music"))
                .shouldHave(text("test.png")).shouldHave(text("г. Н, ул. Пушкина, д. Колотушкина, кв. 101")).shouldHave(text("Uttar Pradesh Agra"));
    }
}
