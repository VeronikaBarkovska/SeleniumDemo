package com.automationpractice.account;

public class AccountCreate {
    private String email;
    private String firstName;
    private String lastName;
    private String passwd;
    private String firstNameAddr;
    private String lastNameAddr;
    private String address1;
    private String city;
    private String postcode;
    private String phone_mobile;
    private String alias;
    private String title;
    private String day;
    private String month;
    private String year;
    private String company;
    private String address2;
    private String state;
    private String country;
    private String addinfo;
    private String homePhone;



    public AccountCreate(){
    }

    public AccountCreate(String email, String firstName, String lastName, String passwd,
                   String firstNameAddr, String lastNameAddr, String address1, String city, String postcode,
                   String phone_mobile, String alias, String title, String day, String month, String year, String company, String address2, String state,String country,String addinfo, String homePhone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwd = passwd;
        this.firstNameAddr = firstNameAddr;
        this.lastNameAddr = lastNameAddr;
        this.address1 = address1;
        this.city = city;
        this.postcode = postcode;
        this.phone_mobile = phone_mobile;
        this.alias = alias;
        this.title = title;
        this.day = day;
        this.month = month;
        this.year = year;
        this.company = company;
        this.address2 = address2;
        this.state = state;
        this.country = country;
        this.addinfo = addinfo;
        this.homePhone = homePhone;

    }

    public String getEmail(){return email;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getFirstNameAddr() {
        return firstNameAddr;
    }

    public String getLastNameAddr() {
        return lastNameAddr;
    }

    public String getAddress1() {
        return address1;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhone_mobile() {
        return phone_mobile;
    }

    public String getAlias() {
        return alias;
    }

    public String getTitle() {return title;}

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress2() {
        return address2;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getAddinfo() {
        return addinfo;
    }

    public String getHomePhone() {
        return homePhone;
    }


    public void setEmail(String email){this.email = email;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setFirstNameAddr(String firstNameAddr) {
        this.firstNameAddr = firstNameAddr;
    }

    public void setLastNameAddr(String lastNameAddr) {
        this.lastNameAddr = lastNameAddr;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPhone_mobile(String phone_mobile) {
        this.phone_mobile = phone_mobile;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddinfo(String addinfo) {
        this.addinfo = addinfo;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }


    public AccountCreate enterEmail(String email){
        this.email = email;
        return this;
    }

    public AccountCreate enterFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AccountCreate enterLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccountCreate enterPassword(String passwd) {
        this.passwd = passwd;
        return this;
    }

    public AccountCreate enterFirstNameAddr(String firstNameAddr) {
        this.firstNameAddr = firstNameAddr;
        return this;
    }

    public AccountCreate enterLastNameAddr(String lastNameAddr) {
        this.lastNameAddr = lastNameAddr;
        return this;
    }

    public AccountCreate enterAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public AccountCreate enterCity(String city) {
        this.city = city;
        return this;
    }

    public AccountCreate enterZipCode(String postcode) {
        this.postcode = postcode;
        return this;
    }


    public AccountCreate enterPhoneMobile(String phone_mobile) {
        this.phone_mobile = phone_mobile;
        return this;
    }

    public AccountCreate enterAliasAddress(String alias) {
        this.alias = alias;
        return this;
    }
    public AccountCreate enterTitle(String title) {
        this.title = title;
        return this;
    }
    public AccountCreate enterDay(String day) {
        this.day = day;
        return this;
    }
    public AccountCreate enterMonth(String month) {
        this.month = month;
        return this;
    }
    public AccountCreate enterYear(String year) {
        this.year = year;
        return this;
    }
    public AccountCreate enterCompany(String company) {
        this.company = company;
        return this;
    }
    public AccountCreate enterAddress2(String address2) {
        this.address2 = address2;
        return this;
    }
    public AccountCreate enterState(String state) {
        this.state = state;
        return this;
    }
    public AccountCreate enterCountry(String country) {
        this.country = country;
        return this;
    }
    public AccountCreate enterAddinfo(String addinfo) {
        this.addinfo = addinfo;
        return this;
    }
    public AccountCreate enterHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }



    public AccountCreate build() {
        return new AccountCreate(email, firstName, lastName, passwd, firstNameAddr, lastNameAddr, address1, city, postcode, phone_mobile, alias, title, day, month, year, company, address2, state, country, addinfo, homePhone);
    }
}
