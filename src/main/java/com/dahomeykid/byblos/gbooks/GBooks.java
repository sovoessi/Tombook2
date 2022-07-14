package com.dahomeykid.byblos.gbooks;

import com.dahomeykid.byblos.gbooks.items.Items;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GBooks {

    private String kind;
    private int totalItems;
    private Items[] items;

    public GBooks(){}

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    public Items[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "GBooks{" +
                "kind='" + kind + '\'' +
                ", totalItems=" + totalItems +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
