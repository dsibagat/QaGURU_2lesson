package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class InputFields {

    SelenideElement
            firstName = $("#firstName"),
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

    @Step("Open students registration form")
    public InputFields openPracticeForm() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    @Step("Set First Name")
    public InputFields setFirstName(String firstNameValue) {
        firstName.val(firstNameValue);
        return this;
    }

    @Step("Set Last Name")
    public InputFields setLastName(String lastNameValue) {
        lastName.val(lastNameValue);
        return this;
    }

    @Step("Set Email")
    public InputFields setUserEmail(String userEmailValue) {
        userEmail.val(userEmailValue);
        return this;
    }

    @Step("Set mobile num")
    public InputFields setUserNumber(String userNumberValue) {
        userNumber.val(userNumberValue);
        return this;
    }

    @Step("Select male gender")
    public InputFields clickRadioButtonGenderMale() {
        radioButtonMale.click();
        return this;
    }

    @Step("Click on Calendar")
    public InputFields clickOnDateOfBirth() {
        dateOfBirth.click();
        return this;
    }

    @Step("Select day")
    public InputFields selectBirthDayInCalendar() {
        birthDay.click();
        return this;
    }

    @Step("Select month")
    public InputFields selectMonth(String birthMonth) {
        monthOfBirth.selectOption(birthMonth);
        return this;
    }

    @Step("Select year")
    public InputFields selectYear(String birthYear) {
        yearOfBirth.selectOption(birthYear);
        return this;
    }

    @Step("Set subject")
    public InputFields setSubject(String subject) {
        subjectsInput.val(subject).pressEnter();
        return this;
    }

    @Step("Select music hobby")
    public InputFields clickOnMusicCheckBoxHobby() {
        checkBoxMusic.click();
        return this;
    }

    @Step("Select sports hobby")
    public InputFields clickOnSportsCheckBoxHobby() {
        checkBoxSports.click();
        return this;
    }

    @Step("Upload file")
    public InputFields uploadFile(String fileSource) {
        uploadFile.uploadFromClasspath(fileSource);
        return this;
    }

    @Step("Set address")
    public InputFields setCurrentAddress(String address) {
        currentAddress.val(address);
        return this;
    }

    @Step("Click on state dropdown")
    public InputFields clickOnStateDropDown() {
        dropDownState.scrollTo().click();
        return this;
    }

    @Step("Choose state in state dropdown")
    public InputFields chooseStateNCR() {
        dropDownStateNCR.click();
        return this;
    }

    @Step("Click on city dropdown")
    public InputFields clickOnCityDropDown() {
        dropDownCity.click();
        return this;
    }

    @Step("Choose city in city dropdown")
    public InputFields chooseCityDelhi() {
        dropDownCityDelhi.click();
        return this;
    }

    @Step("Click on submit")
    public InputFields clickSubmit() {
        clickSubmit.click();
        return this;
    }
}

