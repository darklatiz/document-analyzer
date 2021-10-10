package mx.gigabyte.labs.document.analyzer.web.rest.response;

import mx.gigabyte.labs.document.analyzer.domain.model.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentResponseMapper {

  public DocumentResponse toDocumentResponse(Document boostrap) {
    return DocumentResponse.builder()
      .documentResponseData(DocumentResponse.DocumentResponseData
        .builder()
        .userData(DocumentResponse.UserData.builder()
          .email(boostrap.getProfile().getEmail())
          .name(boostrap.getProfile().getName().concat(" ").concat(boostrap.getProfile().getLastName()))
          .userName(boostrap.getProfile().getUserName())
          .build())
        .build())
      .build();
  }

}
