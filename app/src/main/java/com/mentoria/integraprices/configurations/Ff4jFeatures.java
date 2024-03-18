package com.mentoria.integraprices.configurations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Ff4jFeatures {

  FIND_SELLER_ON_HTTP(
      "find-seller-on-http",
      "features",
      "Consulta o seller via http quando ativado, caso contrário a consulta é feita pelo mongo.",
      true);

  private final String key;
  private final String groupName;
  private final String description;
  private final boolean defaultValue;
}
