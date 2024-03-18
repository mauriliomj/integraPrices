package com.mentoria.integraprices.gateways.outputs.mongodb.documents;

import com.mentoria.integraprices.domains.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDocument {

  private String type;
  private String value;

  public ContactDocument(Contact contact) {

    this.type = contact.getType();
    this.value = contact.getValue();

  }

  public Contact toDomain() {
    return new Contact(this.type, this.value);
  }

}
