package mx.gigabyte.labs.document.analyzer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profile")
public class User extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "profile_id")
  private long profileId;

  @OneToMany(mappedBy = "profile")
  private Set<Document> documents;

  @Column(name = "name", nullable = false, length = 75)
  private String name;

  @Column(name = "last_name", nullable = false, length = 150)
  private String lastName;

  @Column(name = "user_name", nullable = false, unique = true, length = 30)
  private String userName;

  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;

  @Builder
  public User(boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String modifiedBy, long profileId, Set<Document> documents, String name, String lastName, String userName, String email) {
    super(isActive, createdAt, updatedAt, createdBy, modifiedBy);
    this.profileId = profileId;
    this.documents = documents;
    this.name = name;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
  }
}
