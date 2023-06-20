package tests;

import org.junit.jupiter.api.Test;
import tests.pages.RegistrationPage;

public class RegistrationTests {

    RegistrationPage registrationPage = new RegistrationPage();
    public static String imgFilePath = "src/test/resources/haha.jpg";

    @Test
    void mySuccessfulRegistrationFormTest(){

        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Addis")
                .setLastName("Ababa")
                .setEmail("addisababa@mail.com")
                .selectGender("other") // male, female, other
                .setUserMobNumber("1010101010") // 10 digits
                .setDateOfBirth("16", "february", "1992")
                .subjectSet("Computer Science")
                .pickHobbies("Sports,Reading, Music") // there are only: Sports, Reading, Music
                .uploadPicture(imgFilePath)
                .setCurrentAddress("Russia, Saint-Petersburg")
                .selectStateAndCity("NCR", "Gurgaon") // NCR : Delhi, Gurgaon, Noida; Uttar Pradesh : Arga, Lucknow, Merrut
                .pressSubmitButton();


        registrationPage
                .formVerificationWindow("Student Name", "Addis Ababa")
                .formVerificationWindow("Student Email", "addisababa@mail.com")
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
