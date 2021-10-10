package mx.gigabyte.labs.document.analyzer.web.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BootstrapCommand {

  @JsonProperty("user_info")
  @NotNull(message = "user_info should not be null")
  @Valid
  private UserInfo userInfo;

}
