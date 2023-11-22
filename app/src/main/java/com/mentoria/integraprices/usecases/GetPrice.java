package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.domains.Price;
import com.mentoria.integraprices.exceptions.NotFoundException;
import com.mentoria.integraprices.gateways.outputs.PriceDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GetPrice {

    private PriceDataGateway priceDataGateway;

    public Optional<Price> execute(String sku, String sellerId){

        if(priceDataGateway.findBySkuAndSellerId(sku, sellerId).isEmpty()){

            throw new NotFoundException("Sku/sellerId não encontrado!");

        }

        return priceDataGateway.findBySkuAndSellerId(sku, sellerId);

    }
}
