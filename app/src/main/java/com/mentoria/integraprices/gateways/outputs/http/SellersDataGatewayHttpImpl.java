package com.mentoria.integraprices.gateways.outputs.http;

import com.mentoria.integraprices.domains.Seller;
import com.mentoria.integraprices.gateways.outputs.SellersDataGateway;
import com.mentoria.integraprices.gateways.outputs.http.feign.SellersFeignIntegration;
import com.mentoria.integraprices.gateways.outputs.http.resources.SellerResource;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("SellersDataGatewayHttpImpl")
@RequiredArgsConstructor
public class SellersDataGatewayHttpImpl implements SellersDataGateway {
  @Autowired
  public SellersFeignIntegration sellersFeignIntegration;

  @Override
  public boolean exists(String sellerId) {
    Optional<SellerResource> sellerResource = sellersFeignIntegration.get(sellerId);
    return sellerResource.isPresent();
  }

  @Override
  public void save(Seller seller) {
    throw new RuntimeException("Não implementado.");
  }
}
