package tests;

import org.junit.jupiter.api.Test;
import tests.pages.TextBoxPage;

public class TestBoxTest {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxTest(){
        textBoxPage.openPage()
                .removeBanner()
                .setFullName("Addis", "Ababa")
                .setEmail("addisababa@mail.com")
                .setCurrentAddress("woods")
                .setPermanentAddress("saint-petersburg")
                .pressSubmitButton();

        textBoxPage
                .outputVerification("Name", "Addis Ababa")
                .outputVerification("Email", "addisababa@mail.com")
                .outputVerification("Curr", "woods")
                .outputVerification("Perm", "saint-petersburg");
    }

}
