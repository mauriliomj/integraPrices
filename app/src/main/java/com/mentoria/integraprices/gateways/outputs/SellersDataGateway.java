package com.mentoria.integraprices.gateways.outputs;

import com.mentoria.integraprices.domains.Seller;
import org.springframework.stereotype.Component;

@Component
public interface SellersDataGateway {
  boolean exists(String sellerId);

  void save(Seller seller);
}
