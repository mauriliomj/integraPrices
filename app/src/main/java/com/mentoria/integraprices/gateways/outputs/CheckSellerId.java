package com.mentoria.integraprices.gateways.outputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckSellerId {
  @Autowired
  private SellersDataGateway sellersDataGateway;

  public Boolean validate(String sellerId){
    return sellersDataGateway.exists(sellerId);
  }
}
