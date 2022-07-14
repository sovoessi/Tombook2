package com.dahomeykid.byblos.gbooks.items.saleinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class SaleInfo {

    private String country;
    private ListPrice listPrice;
    private RetailPrice retailPrice;

    public SaleInfo() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ListPrice getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "SaleInfo{" +
                "country='" + country + '\'' +
                ", listPrice=" + listPrice +
                ", retailPrice=" + retailPrice +
                '}';
    }
}
