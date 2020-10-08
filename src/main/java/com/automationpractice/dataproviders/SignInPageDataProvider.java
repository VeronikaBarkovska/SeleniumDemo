package com.automationpractice.dataproviders;

import com.automationpractice.account.AccountCreate;
import org.testng.annotations.DataProvider;


public class SignInPageDataProvider {


    @DataProvider
    public Object[][] registerNewUser() {
        return new Object[][]{
                {new AccountCreate()
                        .enterEmail("")
                        .enterPassword("")
                        .build()},
                {new AccountCreate()
                        .enterEmail("veronikabark353536@gmailcom")
                        .enterPassword("password")
                        .build()},
                {new AccountCreate()
                        .enterEmail("veronikabark353536gmail.com")
                        .enterPassword("12345678admin")
                        .build()},
                {new AccountCreate()
                        .enterEmail("veronika bark353536@gmail.com")
                        .enterPassword("12345678aDMIN")
                        .build()},
                {new AccountCreate()
                        .enterEmail("@gmail.com")
                        .enterPassword("12345678Admin")
                        .build()},
                {new AccountCreate()
                        .enterEmail("veronikabark353536@")
                        .enterPassword("12345678ADMIN")
                        .build()}
        };
    }
}
