package com.mentoria.integraprices.gateways.inputs.controllers;

import com.mentoria.integraprices.domains.Price;
import com.mentoria.integraprices.gateways.inputs.jsons.PriceRequest;
import com.mentoria.integraprices.usecases.AddPrice;
import com.mentoria.integraprices.usecases.GetPrice;
import com.mentoria.integraprices.usecases.UpdatePrice;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/products/{sku}/prices")
public class PriceController {

  @Autowired
  private AddPrice addPrice;
  @Autowired
  private GetPrice getPrice;
  @Autowired
  private UpdatePrice updatePrice;

  @PostMapping
  @ApiOperation("Cadastra os preços a um determinado produto.")
  public void addPrice(@PathVariable String sku, @RequestHeader String sellerId,
      @RequestBody PriceRequest priceRequest) {

    addPrice.execute(priceRequest.toDomain(sku, sellerId));

  }

  @GetMapping
  @ApiOperation("Pesquisa e retorna o preço pelo sku e sellerId.")
  public Optional<Price> getPrice(@PathVariable String sku, @RequestHeader String sellerId) {

    return getPrice.execute(sku, sellerId);

  }

  @PutMapping
  @ApiOperation("Atualiza os preços cadastrados.")
  public void updatePriceBySellerId(@PathVariable String sku, @RequestHeader String sellerId,
      @RequestBody PriceRequest priceRequest) {

    updatePrice.execute(sku, sellerId, priceRequest.toDomain(sku, sellerId));

  }
}
