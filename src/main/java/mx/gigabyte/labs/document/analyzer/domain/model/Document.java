package mx.gigabyte.labs.document.analyzer.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.gigabyte.labs.document.analyzer.domain.model.enums.DocumentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class Document extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "profile_id", nullable = false)
  private User profile;

  @Column(name = "name", nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "document_type")
  private DocumentType documentType;

  @Column(name = "mime_type")
  private String mimeType;

  @Builder
  public Document(boolean isActive,
                  LocalDateTime createdAt,
                  LocalDateTime updatedAt,
                  String createdBy,
                  String modifiedBy,
                  long id,
                  User profile,
                  String name,
                  DocumentType documentType,
                  String mimeType) {
    super(isActive, createdAt, updatedAt, createdBy, modifiedBy);
    this.id = id;
    this.profile = profile;
    this.name = name;
    this.documentType = documentType;
    this.mimeType = mimeType;
  }

  /**
   * Uploads a document to the server
   */
  public void save() {

  }

  /**
   * Extracts metadata
   */
  public void extractMetadata() {

  }

  /**
   * Sends the File to the processing QUEUE
   */
  public void sendToQueue() {

  }
}
