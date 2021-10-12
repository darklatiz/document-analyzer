package mx.gigabyte.labs.document.analyzer.web.rest.response;

import mx.gigabyte.labs.document.analyzer.domain.model.record.BootstrapRecord;
import org.springframework.stereotype.Component;

@Component
public class DocumentResponseMapper {

  public DocumentResponse toDocumentResponse(BootstrapRecord boostrap) {
    return DocumentResponse.builder()
      .documentResponseData(DocumentResponse.DocumentResponseData
        .builder()
        .userData(DocumentResponse.UserData.builder()
          .id(boostrap.userRecord().getProfileId())
          .email(boostrap.userRecord().getEmail())
          .name(boostrap.userRecord().getName().concat(" ").concat(boostrap.userRecord().getLastName()))
          .userName(boostrap.userRecord().getUserName())
          .build())
        .build())
      .build();
  }

}
