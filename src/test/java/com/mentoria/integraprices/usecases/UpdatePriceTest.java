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
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UpdatePriceTest {

    @InjectMocks
    private UpdatePrice updatePrice;

    @Mock
    private PriceDataGateway priceDataGateway;

    @Test
    public void shouldChangeAPriceBySkuAndSellerId(){

        Mockito.when(priceDataGateway.findBySkuAndSellerId(mockPrice().getSku(), mockPrice().getSellerId()))
                .thenReturn(Optional.of(mockPrice()));

        updatePrice.execute(mockPrice().getSku(),
                mockPrice().getSellerId(), mockPriceUpdated());

        Mockito.verify(priceDataGateway).save(any());

    }

    @Test
    public void shouldThrowExceptionForNotFindingId(){

        Mockito.when(priceDataGateway.findBySkuAndSellerId(any(), any()))
                .thenThrow(new NotFoundException("Id não encontrado."));

        Assertions.assertThrows(NotFoundException.class, ()-> updatePrice
                .execute(mockPrice().getSellerId(),mockPrice().getSku(),
                        mockPriceUpdated()));

    }

    public Price mockPrice(){

        Price mockPrice = new Price();
        mockPrice.setSku("SkuTest");
        mockPrice.setSellerId("IdTest");
        mockPrice.setListPriceInCents(50);
        mockPrice.setSalePriceInCents(40);
        return mockPrice;

    }

    public Price mockPriceUpdated(){

        Price mockPriceUpdated = new Price();
        mockPriceUpdated.setListPriceInCents(120);
        mockPriceUpdated.setSalePriceInCents(90);
        return mockPriceUpdated;

    }
}