package com.automationpractice.pages.enums;

public enum SortEnum {
    PRICELOWESTFIRST("Price: Lowest first"),
    PRICEHIGHESTFIRST("Price: Highest first"),
    PRODUCTNAMEATOZ("Product Name: A to Z"),
    PRODUCTNAMEZTOA("Product Name: Z to A"),
    INSTOCK("In stock"),
    REFERENCELOWESTFIRST("Reference: Lowest first"),
    REFERENCEHIGHESTFIRST("Reference: Highest first");
    private String name;

    SortEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
