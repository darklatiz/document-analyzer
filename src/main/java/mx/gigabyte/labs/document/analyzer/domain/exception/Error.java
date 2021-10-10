package mx.gigabyte.labs.document.analyzer.domain.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Error {
  private String field;
  private String issue;
}
