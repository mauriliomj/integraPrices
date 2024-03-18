package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.configurations.Ff4jFeatures;
import com.mentoria.integraprices.gateways.outputs.http.SellersDataGatewayHttpImpl;
import com.mentoria.integraprices.gateways.outputs.mongodb.SellersDataGatewayMongoImpl;
import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CheckSellerId {

  @Autowired
  @Qualifier("sellersDataGatewayHttpImpl")
  private SellersDataGatewayHttpImpl sellersDataGatewayHttpImpl;
  @Autowired
  @Qualifier("sellersDataGatewayMongoImpl")
  private SellersDataGatewayMongoImpl sellersDataGatewayMongoImpl;
  @Autowired
  private FF4j ff4j;

  public Boolean validate(String sellerId) {
    if(ff4j.check(Ff4jFeatures.FIND_SELLER_ON_HTTP.getKey())){
      return sellersDataGatewayHttpImpl.exists(sellerId);
    }
    return sellersDataGatewayMongoImpl.exists(sellerId);
  }
}
