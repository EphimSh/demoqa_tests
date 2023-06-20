package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.component.calendar.CalendarComponent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userMobNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsContainer = $("#subjectsContainer"),
            uploadPictureBTN = $("#uploadPicture"),
            currentAddressField = $("#currentAddress"),
            stateDropDown = $("#state"),
            cityDropDown = $("#city"),
            submitButton = $("#submit"),
            tableResponsive = $(".table-responsive");




    private final ElementsCollection hobbiesList = $$("#hobbiesWrapper [class*='custom-checkbox']");



    public RegistrationPage openPage() {
        open("automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        genderWrapper.$(byTextCaseInsensitive(gender)).click();
        return this;
    }

    public RegistrationPage setUserMobNumber(String tenDigitsMobileNumber) {
        userMobNumber.setValue(tenDigitsMobileNumber);
        return this;
    }


    public RegistrationPage subjectSet(String subject) {
        subjectsContainer.click();
        subjectsContainer.$("#subjectsInput").setValue(subject).sendKeys(Keys.ARROW_DOWN);
        subjectsContainer.$("#subjectsInput").pressEnter();
        return this;
    }

    public RegistrationPage pickHobbies(String hobby) {
        List<String> hobbies = new ArrayList<>(Arrays.asList(hobby.split("\\s*,\\s*")));
        for (String h : hobbies) {
            hobbiesList.find(text(h)).click();

        }
        return this;

    }

    public RegistrationPage uploadPicture(String filePath) {
        uploadPictureBTN.uploadFile(new File(filePath));
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressField.setValue(address);
        return this;
    }

    public RegistrationPage selectStateAndCity(String state, String city) {
        stateDropDown.click();
        $(byText(state)).click();
        $(byText(state)).click();
        cityDropDown.click();
        cityDropDown.$(byText(city)).click();
        return this;
    }

    public RegistrationPage pressSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage formVerificationWindow(String key, String value){
        tableResponsive.$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }
}
