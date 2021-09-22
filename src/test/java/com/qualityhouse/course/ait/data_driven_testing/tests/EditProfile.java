package com.qualityhouse.course.ait.data_driven_testing.tests;

import com.qualityhouse.course.ait.data_driven_testing.pageobjects.CommonPageObjects;
import com.qualityhouse.course.ait.data_driven_testing.pageobjects.EditProfilePageObject;
import com.qualityhouse.course.ait.data_driven_testing.pageobjects.LoginPageObject;
import com.qualityhouse.course.ait.data_driven_testing.support.User;
import com.qualityhouse.course.ait.data_driven_testing.support.Utils;
import com.qualityhouse.course.ait.data_driven_testing.testdata.EditProfileTestData;
import com.qualityhouse.course.ait.data_driven_testing.testdata.LoginTestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditProfile {

    private WebDriver driver = new ChromeDriver();

    private LoginPageObject loginPage = new LoginPageObject(driver);

    private CommonPageObjects common = new CommonPageObjects(driver);

    private EditProfilePageObject editProfilePage = new EditProfilePageObject(driver);

    @Before
    public void setup() { common.openApplication(); }

    @After
    public void tearDown() {
        common.closeApplication();
    }

    @Test
    public void tcEditProfileWithValidData() {
        // todo: Exercise no. 3 - create "main test script" for the valid modification of user's profile
        for (User user : EditProfileTestData.validUsers) {
            // so called "main test script"
            loginPage.open();
            loginPage.populateUsername(user.getUsername());
            loginPage.populatePassword(user.getPassword());
            loginPage.login();
            Utils.isPresent(driver, common.menuLogout);
            common.logout();
        }
    }

    @Test
    public void tcEditProfileWithInvalidData() {
        // todo: Exercise no. 4.b - create "main test script" for the invalid modification of user's profile
        // hint: driver.switchTo().alert().dismiss()

    }

}
