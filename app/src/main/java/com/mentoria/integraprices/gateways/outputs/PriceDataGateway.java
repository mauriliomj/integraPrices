package com.mentoria.integraprices.gateways.outputs;

import com.mentoria.integraprices.domains.Price;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface PriceDataGateway {

  void save(Price price);

  Optional<Price> findBySkuAndSellerId(String sku, String sellerID);

}
