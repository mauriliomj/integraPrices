package com.mentoria.integraprices.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

  private String sellerId;
  private String sku;
  private Integer listPriceInCents;
  private Integer salePriceInCents;

}
