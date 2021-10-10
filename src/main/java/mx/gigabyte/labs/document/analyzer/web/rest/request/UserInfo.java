package mx.gigabyte.labs.document.analyzer.web.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

  @JsonProperty("name")
  @NotNull
  @Size(min = 5, max = 100)
  private String name;

  @JsonProperty("last_name")
  @NotBlank
  @Size(min = 5, max = 100)
  private String lastName;

  @JsonProperty("email")
  @NotBlank
  @Email
  private String email;

  @JsonProperty("user_name_same_as_email")
  private boolean isUserNameSameAsEmail;

  @JsonProperty("user_name")
  private String userName;
}