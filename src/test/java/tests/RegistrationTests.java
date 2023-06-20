package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    public static String imgFilePath = "src/test/resources/haha.jpg";

    private static String imgFileName = imgFilePath.substring(imgFilePath.lastIndexOf("/") + 1);

    @Test
    void mySuccessfulRegistrationFormTest(){

        String firstname = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = getRandomGender(),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                day = String.valueOf(faker.random().nextInt(1,28)),
                month = getRandomMonth(),
                year = String.valueOf(getRandomInt(1900, 2100)),
                subject = getRandomSubject(),
                hobby = getRandomHobby(),
                address = faker.address().fullAddress(),
                state = getRandomState(),
                city = getRandomCity();




        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstname)
                .setLastName(lastName)
                .setEmail(userEmail)
                .selectGender(gender) // male, female, other
                .setUserMobNumber(userNumber) // 10 digits
                .setDateOfBirth(day, month, year)
                .subjectSet(subject)
                .pickHobbies(hobby) // there are only: Sports, Reading, Music
                .uploadPicture(imgFilePath)
                .setCurrentAddress(address)
                .selectStateAndCity(state, city) // NCR : Delhi, Gurgaon, Noida; Uttar Pradesh : Arga, Lucknow, Merrut
                .pressSubmitButton();


        registrationPage
                .formVerificationWindow("Student Name", firstname + " " + lastName)
                .formVerificationWindow("Student Email", userEmail)
                .formVerificationWindow("Gender", gender)
                .formVerificationWindow("Mobile", userNumber)
                .formVerificationWindow("Date of Birth", day + " " + month +"," + year)
                .formVerificationWindow("Subjects", subject)
                .formVerificationWindow("Hobbies", hobby)
                .formVerificationWindow("Picture", imgFileName)
                .formVerificationWindow("Address", address)
                .formVerificationWindow("State and City", state + " " + city);
    }
}
