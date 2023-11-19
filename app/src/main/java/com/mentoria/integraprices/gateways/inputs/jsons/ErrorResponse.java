package com.mentoria.integraprices.gateways.inputs.jsons;

import java.util.List;

public class ErrorResponse {

  private List<String> errors;

  public ErrorResponse(final List<String> errors) {

    this.errors = errors;

  }

  public List<String> getErrors() {

    return this.errors;

  }

}
