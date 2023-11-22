package com.mentoria.integraprices.gateways.outputs.mongodb;

import com.mentoria.integraprices.domains.Price;
import com.mentoria.integraprices.gateways.outputs.PriceDataGateway;
import com.mentoria.integraprices.gateways.outputs.mongodb.repositories.PriceRepository;
import com.mentoria.integraprices.gateways.outputs.mongodb.documents.PriceDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class PriceDataGatewayMongoImpl implements PriceDataGateway {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public void save(Price price) {

        priceRepository.save(new PriceDocument(price));

    }

    @Override
    public Optional<Price> findBySkuAndSellerId(String sku, String sellerId) {

        return priceRepository.findBySkuAndSellerId(sku, sellerId)
                .map(PriceDocument::toDomain);

    }
}
