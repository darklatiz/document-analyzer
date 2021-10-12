package mx.gigabyte.labs.document.analyzer.domain.model.record;

public record UserRecord(long id, String name, String lastName, String email, String userName, boolean isUserNameSameAsEmail) {

  public UserRecord(String name, String lastName, String email, String userName, boolean isUserNameSameAsEmail) {
    this(-1, name, lastName, email, userName, isUserNameSameAsEmail);
  }

  public String getRealUserName() {
    if (isUserNameSameAsEmail()) {
      return email();
    }
    return userName();
  }

}
