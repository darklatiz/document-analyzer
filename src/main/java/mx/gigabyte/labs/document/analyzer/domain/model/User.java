package mx.gigabyte.labs.document.analyzer.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_profile")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long profileId;
  private String name;
  private String lastName;
  private String userName;
  private String email;

}
