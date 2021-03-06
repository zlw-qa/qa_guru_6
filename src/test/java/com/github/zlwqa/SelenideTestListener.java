package com.github.zlwqa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTestListener extends TestBase {

    @Test
    @Owner("Vasilii Shalunov")
    @Feature("Репозитории")
    @Story("Отображение элементов в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Listener. Отображение табы Issues в репозитории zlw-qa/qa_guru_6")
    @Link(name = "GitHub", url = "https://github.com")
    public void checkIssueNameInRepositoryTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Открыть github.com
        open("https://github.com/");
        // Ввести название репозитория zlw-qa/qa_guru_6
        $("[name=q]").setValue("zlw-qa/qa_guru_6").pressEnter();
        // В результате поиска перейти в репозиторий zlw-qa/qa_guru_6
        $(linkText("zlw-qa/qa_guru_6")).click();
        // Проверить, что таб Issues существует
        $("#issues-tab").shouldHave(text("Issues"));

    }
}
