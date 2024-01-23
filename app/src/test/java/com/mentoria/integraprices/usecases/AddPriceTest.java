package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.domains.Price;
import com.mentoria.integraprices.exceptions.AlreadyRegisteredException;
import com.mentoria.integraprices.gateways.outputs.PriceDataGateway;
import com.mentoria.integraprices.gateways.outputs.SellersDataGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AddPriceTest {
  @InjectMocks
  private AddPrice addPrice;

  @Mock
  private PriceDataGateway priceDataGateway;

  @Mock
  private SellersDataGateway sellersDataGateway;

  @Test
  public void shouldSaveAPrice() {
    Price priceTest = mockPrice();

    Mockito.when(sellersDataGateway.exists(mockPrice().getSellerId())).thenReturn(true);

    Mockito.when(priceDataGateway
            .findBySkuAndSellerId(priceTest.getSku(), priceTest.getSellerId()))
        .thenReturn(Optional.empty());

    addPrice.execute(mockPrice());

    Mockito.verify(priceDataGateway).save(mockPrice());
  }

  @Test
  public void shouldThrowAnExceptionBySellerId() {
    Mockito.when(sellersDataGateway.exists(mockPrice().getSellerId())).thenReturn(true);

    Mockito.when(priceDataGateway.findBySkuAndSellerId(mockPrice().getSku(),
            mockPrice().getSellerId()))
        .thenThrow(new AlreadyRegisteredException("Este price já foi cadastrado!"));

    Assertions.assertThrows(AlreadyRegisteredException.class,
        () -> addPrice.execute(mockPrice()));
  }

  @Test
  public void shouldThrowAnExceptionBySku() {
    Mockito.when(sellersDataGateway.exists(mockPrice().getSellerId())).thenReturn(true);

    Mockito.when(priceDataGateway.findBySkuAndSellerId(mockPrice().getSku(),
            mockPrice().getSellerId()))
        .thenThrow(new AlreadyRegisteredException("Este price já foi cadastrado!"));

    Assertions.assertThrows(AlreadyRegisteredException.class,
        () -> addPrice.execute(mockPrice()));
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