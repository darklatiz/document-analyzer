package mx.gigabyte.labs.document.analyzer.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_profile")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long profileId;

  @Column(name = "name", nullable = false, length = 75)
  private String name;
  @Column(name = "last_name", nullable = false, length = 150)
  private String lastName;

  @Column(name = "user_name", nullable = false, unique = true, length = 30)
  private String userName;
  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;

  @Column(name = "is_active")
  private boolean isActive;

  @CreatedDate
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}
