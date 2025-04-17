import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBox {

    @BeforeAll

    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

        @Test
        void successfullTest() {
            open("automation-practice-form");
            $("#firstName").setValue("Thomas");
            $("#lastName").setValue("Anderson");
            $("#userEmail").setValue("neo@matrix.web");
            $("#gender-radio-1").selectRadio("Male");
            $("#userNumber").setValue("8800555353");
            /*$("#hobbies-checkbox-1").click();
            $("").setValue("");
            $("").setValue("");
            $("").setValue("");
            $("").setValue("");
            $("").setValue("");
            $("").setValue("");
            $("").setValue("");
            $("").setValue("");
            $("").setValue("");
            $("#submit").click();*/
           sleep(5000);

        }



}
