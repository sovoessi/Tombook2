package com.dahomeykid.byblos.gbooks.items;

import com.dahomeykid.byblos.gbooks.items.saleinfo.SaleInfo;
import com.dahomeykid.byblos.gbooks.items.volumeinfo.VolumeInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "glibrary")
@AllArgsConstructor
public class Items {

    @Id
    private String  itemsId;

    private String kind;
    private String id;
    private VolumeInfo volumeInfo;
    private SaleInfo saleInfo;

    public Items() {
    }

    public Items(String kind, String id, VolumeInfo volumeInfo, SaleInfo saleInfo) {
        this.kind = kind;
        this.id = id;
        this.volumeInfo = volumeInfo;
        this.saleInfo = saleInfo;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getItemsId() {
        return itemsId;
    }

    public void setItemId(String itemId) {
        this.itemsId = itemId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }



    @Override
    public String toString() {
        return "Items{" +
                "kind='" + kind + '\'' +
                ", id='" + id + '\'' +
                ", volumeInfo=" + volumeInfo +
                ", saleInfo=" + saleInfo +
                '}';
    }

    public Items updateWith(Items items) {
        return new Items(
                items.kind,
                items.id,
                items.volumeInfo,
                items.saleInfo
                );
    }
}
