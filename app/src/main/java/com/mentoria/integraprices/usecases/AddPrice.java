package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.domains.Price;
import com.mentoria.integraprices.exceptions.AlreadyRegisteredException;
import com.mentoria.integraprices.gateways.outputs.PriceDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddPrice {

  private PriceDataGateway priceDataGateway;

  public void execute(Price price) {

    if (priceDataGateway.findBySkuAndSellerId(price.getSku(), price.getSellerId()).isPresent()) {

      throw new AlreadyRegisteredException("Preço já cadastrado para o sellerId/sku");

    }

    priceDataGateway.save(price);

  }
}
