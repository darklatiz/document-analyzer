package mx.gigabyte.labs.document.analyzer.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_profile")
public class User {
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

  @Embedded
  private AuditRecord auditRecord;

}
