package mx.gigabyte.labs.document.analyzer.web.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.gigabyte.labs.document.analyzer.domain.model.enums.DocumentType;

import java.util.List;

@Data
@JsonIgnoreProperties
@Builder
public class DocumentResponse {

  @JsonProperty("api_response")
  private DocumentResponseData documentResponseData;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class DocumentResponseData {

    @JsonProperty("user_data")
    private UserData userData;

    @JsonProperty("documents")
    private List<DocumentData> documentDataList;

  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Data
  @Builder
  public static class UserData{
    private long id;
    private String name;

    @JsonProperty("user_name")
    private String userName;

    private String email;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Data
  @Builder
  public static class DocumentData {
    private long id;

    @JsonProperty("document_type")
    private DocumentType documentType;

    @JsonProperty("file_name")
    private String fileName;
  }
}
