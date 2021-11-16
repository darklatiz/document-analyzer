package mx.gigabyte.labs.document.analyzer.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentException extends RuntimeException {
  public static final int IO_ERROR = 12345;
  private final int code;

  public DocumentException(Throwable cause, int code) {
    super(cause);
    this.code = code;
  }
}
