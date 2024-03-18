package com.mentoria.integraprices.gateways.outputs.mongodb.documents;

import com.mentoria.integraprices.domains.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDocument {

    private String street;
    private String number;
    private String zipcode;
    private String city;
    private String state;
    private String country;

    public AddressDocument(final Address address) {

        this.street = address.getStreet();
        this.number = address.getNumber();
        this.zipcode = address.getZipcode();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();

    }

    public Address toDomain() {

        Address address = new Address(street,number,zipcode,city,state,country);
        address.setStreet(this.street);
        address.setNumber(this.number);
        address.setZipcode(this.zipcode);
        address.setCity(this.city);
        address.setState(this.state);
        address.setCountry(this.country);

        return address;

    }
}
