package com.mentoria.integraprices.gateways.outputs;

import com.mentoria.integraprices.domains.Seller;
import org.ff4j.aop.Flip;
import org.springframework.stereotype.Component;

@Component
@Flip(name = "find-seller-on-http", alterBean = "SellersDataGatewayHttpImpl")
public interface SellersDataGateway {
  boolean exists(String sellerId);

  void save(Seller seller);
}
