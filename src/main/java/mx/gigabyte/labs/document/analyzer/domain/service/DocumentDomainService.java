package mx.gigabyte.labs.document.analyzer.domain.service;

import mx.gigabyte.labs.document.analyzer.domain.exception.DocumentException;
import mx.gigabyte.labs.document.analyzer.domain.model.Document;
import mx.gigabyte.labs.document.analyzer.domain.model.User;
import mx.gigabyte.labs.document.analyzer.domain.model.enums.DocumentType;
import mx.gigabyte.labs.document.analyzer.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class DocumentDomainService {

  private DocumentRepository documentRepository;
  private final Path root = Paths.get("uploads");

  @Autowired
  public DocumentDomainService(DocumentRepository documentRepository) {
    this.documentRepository = documentRepository;
  }

  public void init() {
    try {
      if (Files.notExists(root)) {
        Files.createDirectory(root);
      }
    } catch (IOException e) {
      throw new DocumentException(e);
    }
  }

  public List<Document> save(List<MultipartFile> documents) {
    return null;
  }

  public Document save(MultipartFile file, User profile) throws DocumentException {
    try {

      init();

      String fileName = file.getName();
      String originalFileName = file.getOriginalFilename();
      String contentType = file.getContentType();

      Files.copy(file.getInputStream(),
        this.root.resolve(originalFileName));

      // TODO Mapear los atributos que no estan en el builder
      Document document = Document.builder()
        .profile(profile)
        .name(fileName)
        .documentType(DocumentType.TO_BE_SET)
        .isActive(true)
        .mimeType(contentType)
        .build();

      documentRepository.save(document);

      return document;
    } catch (Exception e) {
      throw new DocumentException(e);
    }
  }
}
