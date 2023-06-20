package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    public static String imgFilePath = "src/test/resources/haha.jpg";

    @Test
    void mySuccessfulRegistrationFormTest(){

        String firstname = getRandomString(10),
                lastName = getRandomString(10),
                userEmail = getRandomEmail(),
                userNumber = getRandomPhoneNumber();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstname)
                .setLastName(lastName)
                .setEmail(userEmail)
                .selectGender(getRandomGender()) // male, female, other
                .setUserMobNumber(userNumber) // 10 digits
                .setDateOfBirth("16", "february", "1992")
                .subjectSet("Computer Science")
                .pickHobbies("Sports,Reading, Music") // there are only: Sports, Reading, Music
                .uploadPicture(imgFilePath)
                .setCurrentAddress("Russia, Saint-Petersburg")
                .selectStateAndCity("NCR", "Gurgaon") // NCR : Delhi, Gurgaon, Noida; Uttar Pradesh : Arga, Lucknow, Merrut
                .pressSubmitButton();


        registrationPage
                .formVerificationWindow("Student Name", firstname + " " + lastName)
                .formVerificationWindow("Student Email", userEmail)
                .formVerificationWindow("Gender", "other")
                .formVerificationWindow("Mobile", "1010101010")
                .formVerificationWindow("Date of Birth", "16 february,1992")
                .formVerificationWindow("Subjects", "Computer Science")
                .formVerificationWindow("Hobbies", "Sports, Reading, Music")
                .formVerificationWindow("Picture", "haha.jpg")
                .formVerificationWindow("Address", "Saint-Petersburg")
                .formVerificationWindow("State and City", "NCR Gurgaon");
    }
}
