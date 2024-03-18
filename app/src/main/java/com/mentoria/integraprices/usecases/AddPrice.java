package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.domains.Price;
import com.mentoria.integraprices.exceptions.AlreadyRegisteredException;
import com.mentoria.integraprices.exceptions.NotFoundException;
import com.mentoria.integraprices.gateways.outputs.PriceDataGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddPrice {

  @Autowired
  private PriceDataGateway priceDataGateway;

  @Autowired
  private CheckSellerId checkSellerId;

  public void execute(Price price) {

    boolean validation = checkSellerId.validate(price.getSellerId());

    if(validation){
      if (priceDataGateway.findBySkuAndSellerId(price.getSku(), price.getSellerId()).isPresent()) {
        throw new AlreadyRegisteredException("Preço já cadastrado para o sellerId/sku");
      }
      priceDataGateway.save(price);
    } else {
      throw new NotFoundException("SellerId não encontrado!");
    }
  }
}
