package mx.gigabyte.labs.document.analyzer.web.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties
public class BootstrapCommand {

  @JsonProperty("user_info")
  private UserInfo userInfo;

  @Data
  @NoArgsConstructor
  @JsonIgnoreProperties
  public static class UserInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("user_name_same_as_email")
    private boolean isUserNameSameAsEmail;

    @JsonProperty("user_name")
    private String userName;
  }

}
