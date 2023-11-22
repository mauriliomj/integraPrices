package com.mentoria.integraprices.gateways.outputs.mongodb.documents;

import com.mentoria.integraprices.domains.Price;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("prices")
public class PriceDocument {

    @Id
    private String sku;
    @Indexed
    private String sellerId;
    private Integer listPriceInCents;
    private Integer salePriceInCents;

    public PriceDocument(Price price){

        this.sku = price.getSku();
        this.sellerId = price.getSellerId();
        this.listPriceInCents = price.getListPriceInCents();
        this.salePriceInCents = price.getSalePriceInCents();

    }

    public Price toDomain(){

        Price price = new Price();
        price.setSku(this.sku);
        price.setSellerId(this.sellerId);
        price.setListPriceInCents(this.listPriceInCents);
        price.setSalePriceInCents(this.salePriceInCents);
        return price;

    }
}
