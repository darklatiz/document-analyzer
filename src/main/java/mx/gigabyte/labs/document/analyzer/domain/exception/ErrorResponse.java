package mx.gigabyte.labs.document.analyzer.domain.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Builder
@Getter
@Setter
public class ErrorResponse {

  private String messageError;
  private int errorCode;
  private List<Error> errors;


}
