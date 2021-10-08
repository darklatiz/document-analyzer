package mx.gigabyte.labs.document.analyzer.web.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties
@Builder
public class DocumentResponse {

  private int code;
  private String message;

}
