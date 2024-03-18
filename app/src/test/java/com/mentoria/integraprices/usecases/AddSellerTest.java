package com.mentoria.integraprices.usecases;

import com.mentoria.integraprices.domains.Address;
import com.mentoria.integraprices.domains.Contact;
import com.mentoria.integraprices.domains.Seller;
import com.mentoria.integraprices.exceptions.AlreadyRegisteredException;
import com.mentoria.integraprices.gateways.outputs.mongodb.documents.SellerDocument;
import com.mentoria.integraprices.gateways.outputs.mongodb.repositories.SellersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddSellerTest {
  @InjectMocks
  private AddSeller addSeller;
  @Mock
  private SellersRepository sellersRepository;

  @Test
  public void ShouldSaveASeller(){
    Mockito.when(sellersRepository.existsById(mockSeller().getSellerId())).thenReturn(false);
    addSeller.execute(mockSeller());
    SellerDocument sellerDocument = new SellerDocument(mockSeller());
    Mockito.verify(sellersRepository.save(sellerDocument));
  }

  @Test
  public void ShouldThrowAlreadyRegisteredException(){
    Mockito.when(sellersRepository.existsById(mockSeller().getSellerId())).thenThrow(new
        AlreadyRegisteredException("Seller já cadastrado!"));

    Assertions.assertThrows(AlreadyRegisteredException.class, () -> addSeller.execute(mockSeller()));
  }

  public Seller mockSeller(){
    Seller mockSeller = new Seller();
    mockSeller.setSellerId("test");
    mockSeller.setName("test");
    mockSeller.setAddress(mockAddress());
    mockSeller.setContact(mockContact());
    mockSeller.setRegistrationCode("test");
    mockSeller.setCreatedDate("date test");
    mockSeller.setLastModifiedDate("date test");
    return mockSeller;
  }

  public Contact mockContact(){
    Contact contact = new Contact("email", "email@email");
    return contact;
  }

  public Address mockAddress(){
    Address address = new Address("street", "number", "zipcode", "city",
        "state", "country");
    return address;
  }
}