package com.automationpractice.info;


import com.automationpractice.pages.enums.SortEnum;

public class InfoCreate {
    private String searchText;
    private SortEnum sortType;

    public InfoCreate(){

    }
    public InfoCreate(String searchText, SortEnum sortType){
        this.searchText = searchText;
        this.sortType = sortType;
    }
    public String getSearchText(){return searchText;}

    public SortEnum getSortType(){return sortType;}

    public void setSearchText(String email){this.searchText = searchText;}

    public void setSortType(SortEnum sortType){this.sortType = sortType;}

    public InfoCreate enterSearchText(String searchText){
        this.searchText = searchText;
        return this;
    }
    public InfoCreate enterSortType(SortEnum sortType){
        this.sortType = sortType;
        return this;
    }
    public InfoCreate build() {
        return new InfoCreate(searchText , sortType);}
}
