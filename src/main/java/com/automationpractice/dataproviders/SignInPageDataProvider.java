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
                        .enterEmail("veronikabark3535@gmailcom")
                        .enterPassword("password")
                        .build()},
                {new AccountCreate()
                        .enterEmail("veronikabark3535gmail.com")
                        .enterPassword("12345678admin")
                        .build()},
                {new AccountCreate()
                        .enterEmail("veronika bark3535@gmail.com")
                        .enterPassword("12345678aDMIN")
                        .build()},
                {new AccountCreate()
                        .enterEmail("@gmail.com")
                        .enterPassword("12345678Admin")
                        .build()},
                {new AccountCreate()
                        .enterEmail("veronikabark3535@")
                        .enterPassword("12345678ADMIN")
                        .build()}
        };
    }
}
