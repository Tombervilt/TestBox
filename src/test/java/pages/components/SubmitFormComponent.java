package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class SubmitFormComponent {

    private final SelenideElement checkResult = $("div[role=document]");
    public void checkResultForm(String fieldName, String value) {
        checkResult.$(byText(fieldName)).parent().shouldHave(text(value));
        //findBy(text(fieldName))
    }

    public void resultFormNotVisible() {
        checkResult.shouldNotBe(visible);
        //findBy(text(fieldName))
    }
}
