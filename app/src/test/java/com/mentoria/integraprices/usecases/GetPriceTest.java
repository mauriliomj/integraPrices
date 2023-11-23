package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.domains.Price;
import com.mentoria.integraprices.exceptions.NotFoundException;
import com.mentoria.integraprices.gateways.outputs.PriceDataGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class GetPriceTest {

  @InjectMocks
  private GetPrice getPrice;
  @Mock
  private PriceDataGateway priceDataGateway;

  @Test
  public void shouldShowAPrice() {

    Mockito.when(priceDataGateway.findBySkuAndSellerId(mockPrice().getSku(),
        mockPrice().getSellerId())).thenReturn(Optional.of(mockPrice()));

    Optional<Price> resultPrice = getPrice
        .execute(mockPrice().getSku(), mockPrice().getSellerId());

    Assertions.assertEquals(resultPrice.get(), mockPrice());

  }

  @Test
  public void shouldThrowAnException() {

    Mockito.when(priceDataGateway
            .findBySkuAndSellerId(mockPrice().getSku(), mockPrice().getSellerId()))
        .thenReturn(Optional.empty());

    Assertions.assertThrows(NotFoundException.class, () -> getPrice
        .execute(mockPrice().getSku(), mockPrice().getSellerId()));

    Mockito.verify(priceDataGateway).findBySkuAndSellerId(mockPrice().getSku(),
        mockPrice().getSellerId());

  }

  public Price mockPrice() {

    Price mockPrice = new Price();
    mockPrice.setSku("SkuTest");
    mockPrice.setSellerId("IdTest");
    mockPrice.setListPriceInCents(50);
    mockPrice.setSalePriceInCents(40);
    return mockPrice;

  }
}