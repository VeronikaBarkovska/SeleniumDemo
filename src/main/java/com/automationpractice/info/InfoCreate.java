package com.automationpractice.info;


public class InfoCreate {
    private String searchText;

    public InfoCreate(){

    }
    public InfoCreate(String searchText){
        this.searchText = searchText;
    }
    public String getSearchText(){return searchText;}

    public void setSearchText(String email){this.searchText = searchText;}

    public InfoCreate enterSearchText(String searchText){
        this.searchText = searchText;
        return this;
    }
    public InfoCreate build() {
        return new InfoCreate(searchText);}
}
