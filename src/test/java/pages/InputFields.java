package pages;

import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.SoftAssertions;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class InputFields {

    SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            radioButtonMale = $(byText("Male")),
            dateOfBirth = $("#dateOfBirthInput"),
            monthOfBirth = $(".react-datepicker__month-select"),
            yearOfBirth = $(".react-datepicker__year-select"),
            birthDay = $(".react-datepicker__day--017"),
            subjectsInput = $("#subjectsInput"),
            checkBoxSports = $(byText("Sports")),
            checkBoxMusic = $(byText("Music")),
            uploadFile = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            dropDownState = $(byText("Select State")),
            dropDownStateNCR = $(byText("NCR")),
            dropDownCity = $(byText("Select City")),
            dropDownCityDelhi = $(byText("Delhi")),
            clickSubmit = $(byText("Submit"));

    public InputFields openPracticeForm() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public InputFields setFirstName(String firstNameValue) {
        firstName.val(firstNameValue);
        return this;
    }

    public InputFields setLastName(String lastNameValue) {
        lastName.val(lastNameValue);
        return this;
    }

    public InputFields setUserEmail(String userEmailValue) {
        userEmail.val(userEmailValue);
        return this;
    }

    public InputFields setUserNumber(String userNumberValue) {
        userNumber.val(userNumberValue);
        return this;
    }

    public InputFields clickRadioButtonGenderMale() {
        radioButtonMale.click();
        return this;
    }

    public InputFields clickOnDateOfBirth() {
        dateOfBirth.click();
        return this;
    }

    public InputFields selectBirthDayInCalendar() {
        birthDay.click();
        return this;
    }

    public InputFields selectMonth(String birthMonth) {
        monthOfBirth.selectOption(birthMonth);
        return this;
    }

    public InputFields selectYear(String birthYear) {
        yearOfBirth.selectOption(birthYear);
        return this;
    }


    public InputFields setSubject(String subject) {
        subjectsInput.val(subject).pressEnter();
        return this;
    }

    public InputFields clickOnMusicCheckBoxHobby() {
        checkBoxMusic.click();
        return this;
    }

    public InputFields clickOnSportsCheckBoxHobby() {
        checkBoxSports.click();
        return this;
    }

    public InputFields uploadFile(String fileSource) {
        uploadFile.uploadFile(new File(fileSource));
        return this;
    }

    public InputFields setCurrentAddress(String address) {
        currentAddress.val(address);
        return this;
    }

    public InputFields clickOnStateDropDown() {
        dropDownState.scrollTo().click();
        return this;
    }

    public InputFields chooseStateNCR() {
        dropDownStateNCR.click();
        return this;
    }

    public InputFields clickOnCityDropDown() {
        dropDownCity.click();
        return this;
    }

    public InputFields chooseCityDelhi() {
        dropDownCityDelhi.click();
        return this;
    }

    public InputFields clickSubmit() {
        clickSubmit.click();
        return this;
    }

    public InputFields checkData(Map<String, String> expectedData) {
        SoftAssertions softly = new SoftAssertions();
        for (SelenideElement element : $$(".table-responsive tbody tr")) {
            String key = element.$("td").getText();
            String actualValue = element.$("td", 1).getText();
            String expectedValue = expectedData.get(key);
            softly.assertThat(actualValue).isEqualTo(expectedValue);
        }
        softly.assertAll();
        return this;
    }
}

