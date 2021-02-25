package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class InputFields {

    SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            monthOfBirth = $(".react-datepicker__month-select"),
            yearOfBirth = $(".react-datepicker__year-select"),
            subjectsInput = $("#subjectsInput"),
            uploadFile = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            dropDownState = $(byText("Select State")),
            dropDownCity = $(byText("Select City")),
            clickSubmit = $(byText("Submit"));

    private SelenideElement getElementByText(String text) {
        return $(byText(text));
    }

    private SelenideElement birthDay(String day) {
        return $$(".react-datepicker__day").filter(not(cssClass(".react-datepicker__day--outside-month")))
                .find(text(day));
    }

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

    @Step("Select '{gender}' gender")
    public InputFields clickRadioButtonGender(String gender) {
        getElementByText(gender).click();
        return this;
    }

    @Step("Click on Calendar")
    public InputFields clickOnDateOfBirth() {
        dateOfBirth.click();
        return this;
    }

    @Step("Select day")
    public InputFields selectBirthDayInCalendar(String day) {
        birthDay(day).click();
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

    @Step("Set subject {subject}")
    public InputFields setSubject(String subject) {
        subjectsInput.val(subject).pressEnter();
        return this;
    }

    @Step("Select '{hobby}' hobby")
    public InputFields clickOnCheckBoxHobby(String hobby) {
        getElementByText(hobby).click();
        return this;
    }

    @Step("Upload file {fileSource}")
    public InputFields uploadFile(String fileSource) {
        uploadFile.uploadFromClasspath(fileSource);
        return this;
    }

    @Step("Set address {address}")
    public InputFields setCurrentAddress(String address) {
        currentAddress.val(address);
        return this;
    }

    @Step("Choose state {state}")
    public InputFields chooseState(String state) {
        dropDownState.scrollTo().click();
        getElementByText(state).click();
        return this;
    }

    @Step("Choose {city} in city dropdown")
    public InputFields chooseCity(String city) {
        dropDownCity.scrollTo().click();
        getElementByText(city).click();
        return this;
    }

    @Step("Click on submit")
    public InputFields clickSubmit() {
        clickSubmit.click();
        return this;
    }
}

