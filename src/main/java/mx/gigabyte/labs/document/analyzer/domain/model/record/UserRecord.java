package mx.gigabyte.labs.document.analyzer.domain.model.record;

public record UserRecord(String name, String lastName, String email, String userName, boolean isUserNameSameAsEmail) {

  public String getRealUserName() {
    if (isUserNameSameAsEmail()) {
      return email();
    }
    return userName();
  }

}
