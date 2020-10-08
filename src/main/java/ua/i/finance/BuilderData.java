package ua.i.finance;

import ua.i.finance.pages.enums.CurrencyEnum;
import ua.i.finance.pages.enums.RateTypeEnum;

public class BuilderData {
    private int sum;
    private RateTypeEnum rateType;
    private CurrencyEnum currency;

    public BuilderData(){
    }

    public BuilderData(int sum, RateTypeEnum rateType, CurrencyEnum currency) {
        this.sum = sum;
        this.rateType = rateType;
        this.currency = currency;
    }

    public int getSum() {
        return sum;
    }

    public RateTypeEnum getRateType() {
        return rateType;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setRateType(RateTypeEnum rateType) {
        this.rateType = rateType;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }


    public BuilderData enterSum(int sum){
        this.sum = sum;
        return this;
    }

    public BuilderData enterRateType(RateTypeEnum rateType){
        this.rateType = rateType;
        return this;
    }

    public BuilderData enterCurrency(CurrencyEnum currency){
        this.currency = currency;
        return this;
    }



    public BuilderData build() {
        return new BuilderData(sum, rateType,currency);
    }
}
