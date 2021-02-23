package tests;

import org.junit.jupiter.api.Test;
import pages.InputFields;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTest {
    InputFields steps = new InputFields();

    @Test
    void checkDataInForm() {
        steps.openPracticeForm()
                .setFirstName("Damir")
                .setLastName("Sib")
                .setUserEmail("test@test.test")
                .setUserNumber("9315469394")
                .clickRadioButtonGenderMale()
                .clickOnDateOfBirth()
                .selectMonth("November")
                .selectYear("1993")
                .selectBirthDayInCalendar()
                .setSubject("Math")
                .clickOnMusicCheckBoxHobby()
                .clickOnSportsCheckBoxHobby()
                .uploadFile("src/test/resources/cat.jpg")
                .setCurrentAddress("Address")
                .clickOnStateDropDown()
                .chooseStateNCR()
                .clickOnCityDropDown()
                .chooseCityDelhi()
                .clickSubmit();
        $(".table-responsive").shouldHave(text("Student Name Damir Sib"), text("Student Email test@test.test"), text("Gender Male"), text("Mobile 9315469394"), text("Date of Birth 17 November,1993"), text("Subjects Maths"), text("Hobbies Music, Sports"), text("Picture cat.jpg"), text("Address Address"), text("State and City NCR Delhi"));
    }
}