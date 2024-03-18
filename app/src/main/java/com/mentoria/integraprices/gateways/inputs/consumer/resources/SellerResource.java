package com.mentoria.integraprices.gateways.inputs.consumer.resources;

import com.mentoria.integraprices.domains.Seller;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@Document("sellers")
public class SellerResource {

    @Id
    private String sellerId;
    private String name;
    @Indexed
    private String registrationCode;
    private ContactResource contact;
    private AddressResource address;
    private String createdDate;
    private String lastModifiedDate;

    public SellerResource(Seller seller) {

        this.sellerId = seller.getSellerId();
        this.name = seller.getName();
        this.registrationCode = seller.getRegistrationCode();
        this.contact = new ContactResource(seller.getContact());
        this.address = new AddressResource(seller.getAddress());
        this.createdDate = seller.getCreatedDate();
        this.lastModifiedDate = seller.getLastModifiedDate();

    }

    public Seller toDomain() {

        Seller seller = new Seller();
        seller.setSellerId(this.sellerId);
        seller.setName(this.name);
        seller.setRegistrationCode(this.registrationCode);
        seller.setContact(this.contact.toDomain());
        seller.setAddress(this.address.toDomain());
        seller.setCreatedDate(this.createdDate);
        seller.setLastModifiedDate(this.lastModifiedDate);

        return seller;

    }
}
