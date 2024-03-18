package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.domains.Seller;
import com.mentoria.integraprices.exceptions.AlreadyRegisteredException;
import com.mentoria.integraprices.gateways.outputs.mongodb.documents.SellerDocument;
import com.mentoria.integraprices.gateways.outputs.mongodb.repositories.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddSeller {
  @Autowired
  private SellersRepository sellersRepository;

  public void execute(Seller seller){
    if(sellersRepository.existsById(seller.getSellerId())){
      throw new AlreadyRegisteredException("Seller já registrado!");
    }
    sellersRepository.save(new SellerDocument(seller));
  }
}
