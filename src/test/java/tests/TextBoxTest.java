package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static utils.RandomUtils.faker;

public class TextBoxTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxTest(){

        String
                firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                currentAddress = faker.address().fullAddress(),
                permanentAddress = faker.address().fullAddress();


        textBoxPage.openPage()
                .removeBanner()
                .setFullName(firstName, lastName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .pressSubmitButton();

        textBoxPage
                .outputVerification("Name", firstName + " " + lastName)
                .outputVerification("Email", email)
                .outputVerification("Curr", currentAddress)
                .outputVerification("Perm", permanentAddress);
    }
}
