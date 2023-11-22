package com.mentoria.integraprices.gateways.inputs.jsons;

import com.mentoria.integraprices.domains.Price;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class PriceRequest {

    @NotNull(message = "{not.null}")
    private Integer listPriceInCents;
    @NotNull(message = "{not.null}")
    private Integer salePriceInCents;

    public Price toDomain(String sku, String sellerId){

        Price price = new Price();
        price.setSku(sku);
        price.setSellerId(sellerId);
        price.setListPriceInCents(this.listPriceInCents);
        price.setSalePriceInCents(this.salePriceInCents);

        return price;

    }
}
