package com.mentoria.integraprices.gateways.inputs.consumer.resources;

import com.mentoria.integraprices.domains.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactResource {

  private String type;
  private String value;

  public ContactResource(Contact contact) {

    this.type = contact.getType();
    this.value = contact.getValue();

  }

  public Contact toDomain() {
    return new Contact(this.type, this.value);
  }

}
