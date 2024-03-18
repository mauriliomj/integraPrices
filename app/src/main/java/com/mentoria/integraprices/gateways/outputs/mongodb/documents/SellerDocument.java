package com.mentoria.integraprices.gateways.outputs.mongodb.documents;

import com.mentoria.integraprices.domains.Seller;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("sellers")
public class SellerDocument {

    @Id
    private String sellerId;
    private String name;
    @Indexed
    private String registrationCode;
    private ContactDocument contact;
    private AddressDocument address;
    private String createdDate;
    private String lastModifiedDate;

    public SellerDocument(Seller seller) {

        this.sellerId = seller.getSellerId();
        this.name = seller.getName();
        this.registrationCode = seller.getRegistrationCode();
        this.contact = new ContactDocument(seller.getContact());
        this.address = new AddressDocument(seller.getAddress());
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
