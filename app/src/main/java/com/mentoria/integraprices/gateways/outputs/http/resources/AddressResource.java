package com.mentoria.integraprices.gateways.outputs.http.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResource {

  private String street;
  private String number;
  private String zipcode;
  private String city;
  private String state;
  private String country;

}
