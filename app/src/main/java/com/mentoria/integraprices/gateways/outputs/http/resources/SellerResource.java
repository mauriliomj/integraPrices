package com.mentoria.integraprices.gateways.outputs.http.resources;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerResource {

  private String sellerId;
  private String name;
  private String registrationCode;
  private ContactResource contact;
  private AddressResource addressResource;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

}
