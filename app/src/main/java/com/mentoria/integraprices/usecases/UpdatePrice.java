package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.domains.Price;
import com.mentoria.integraprices.exceptions.NotFoundException;
import com.mentoria.integraprices.gateways.outputs.PriceDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdatePrice {

    private PriceDataGateway priceDataGateway;

    public void execute(String sku, String sellerId, Price updatePrice){

        if(priceDataGateway.findBySkuAndSellerId(sku, sellerId).isEmpty()){

            throw new NotFoundException("sku/sellerId não encontrado!");

        }

        priceDataGateway.save(updatePrice);

    }
}
