package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.gateways.outputs.SellersDataGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CheckSellerIdTest {
  @InjectMocks
  private CheckSellerId checkSellerId;

  @Mock
  private SellersDataGateway sellersDataGateway;

  @Test
  public void shouldValidateASellerId(){
    String sellerIdTest = "sellerIdTest";

    Mockito.when(sellersDataGateway.exists(sellerIdTest)).thenReturn(true);

    Boolean booleanTest = checkSellerId.validate(sellerIdTest);

    Assertions.assertEquals(booleanTest, true);
  }

  @Test
  public void shouldNotValidateASellerId(){
    String sellerIdTest = "sellerIdTest";

    Mockito.when(sellersDataGateway.exists(sellerIdTest)).thenReturn(false);

    Boolean booleanTest = checkSellerId.validate(sellerIdTest);

    Assertions.assertEquals(booleanTest, false);
  }
}