package com.mentoria.integraprices.gateways.outputs.mongodb.repositories;

import com.mentoria.integraprices.gateways.outputs.mongodb.documents.PriceDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PriceRepository extends MongoRepository<PriceDocument, String> {

  public Optional<PriceDocument> findBySkuAndSellerId(String sku, String sellerId);

}
