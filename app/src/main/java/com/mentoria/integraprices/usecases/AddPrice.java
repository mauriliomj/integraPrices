package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.domains.Price;
import com.mentoria.integraprices.exceptions.AlreadyRegisteredException;
import com.mentoria.integraprices.exceptions.NotFoundException;
import com.mentoria.integraprices.gateways.outputs.PriceDataGateway;
import com.mentoria.integraprices.gateways.outputs.SellersDataGateway;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddPrice {

  @Autowired
  private PriceDataGateway priceDataGateway;

  @Autowired
  private SellersDataGateway sellersDataGateway;

  public void execute(Price price) {

    boolean validation = new CheckSellerId(sellersDataGateway).validation(price.getSellerId());

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
