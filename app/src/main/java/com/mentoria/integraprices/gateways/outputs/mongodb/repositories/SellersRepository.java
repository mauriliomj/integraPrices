package com.mentoria.integraprices.gateways.outputs.mongodb.repositories;

import com.mentoria.integraprices.gateways.outputs.mongodb.documents.SellerDocument;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SellersRepository extends PagingAndSortingRepository<SellerDocument, String> {}
