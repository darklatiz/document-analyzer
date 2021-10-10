package mx.gigabyte.labs.document.analyzer.web.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Data
  @Builder
  public static class UserData{
    private String name;

    @JsonProperty("user_name")
    private String userName;

    private String email;
  }

}
