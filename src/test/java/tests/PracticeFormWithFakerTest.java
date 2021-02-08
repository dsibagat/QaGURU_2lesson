package tests;

import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.InputFields;

import java.util.HashMap;
import java.util.Map;

public class PracticeFormWithFakerTest {
    InputFields steps = new InputFields();

    @Description("проверка данных в форме c использованием рандомных значений")
    @Test
    void checkDataInFormWithFaker() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                mobile = faker.phoneNumber().subscriberNumber(10),
                currentAddress = faker.address().fullAddress();

        Map<String, String> expectedData = new HashMap<>() {{
            put("Student Name", firstName + " " + lastName);
            put("Student Email", email);
            put("Gender", "Male");
            put("Mobile", mobile);
            put("Date of Birth", "17 November,1993");
            put("Subjects", "Maths");
            put("Hobbies", "Music, Sports");
            put("Picture", "cat.jpg");
            put("Address", currentAddress);
            put("State and City", "NCR Delhi");
        }};

        steps.openPracticeForm()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUserNumber(mobile)
                .clickRadioButtonGenderMale()
                .clickOnDateOfBirth()
                .selectMonth("November")
                .selectYear("1993")
                .selectBirthDayInCalendar()
                .setSubject("Math")
                .clickOnMusicCheckBoxHobby()
                .clickOnSportsCheckBoxHobby()
                .uploadFile("src/test/resources/cat.jpg")
                .setCurrentAddress(currentAddress)
                .clickOnStateDropDown()
                .chooseStateNCR()
                .clickOnCityDropDown()
                .chooseCityDelhi()
                .clickSubmit()
                .checkData(expectedData);
    }
}