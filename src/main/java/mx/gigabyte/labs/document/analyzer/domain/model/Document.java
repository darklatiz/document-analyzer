package mx.gigabyte.labs.document.analyzer.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Document {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
}
