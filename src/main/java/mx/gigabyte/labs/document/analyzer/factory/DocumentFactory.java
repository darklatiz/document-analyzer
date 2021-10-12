package mx.gigabyte.labs.document.analyzer.factory;

import lombok.extern.slf4j.Slf4j;
import mx.gigabyte.labs.document.analyzer.domain.model.Document;
import mx.gigabyte.labs.document.analyzer.domain.model.User;
import mx.gigabyte.labs.document.analyzer.domain.model.record.BootstrapRecord;
import mx.gigabyte.labs.document.analyzer.domain.model.record.UserRecord;
import mx.gigabyte.labs.document.analyzer.domain.service.DocumentDomainService;
import mx.gigabyte.labs.document.analyzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DocumentFactory {

  private final UserRepository userRepository;
  private final DocumentDomainService documentDomainService;


  @Autowired
  public DocumentFactory(UserRepository userRepository, DocumentDomainService documentDomainService) {
    this.userRepository = userRepository;
    this.documentDomainService = documentDomainService;
  }

  @Transactional
  public BootstrapRecord bootStrap(UserRecord userRecord, List<MultipartFile> files) {
    log.info("Creating new Profile {}", userRecord);
    User newProfile = User.builder()
      .name(userRecord.name())
      .lastName(userRecord.lastName())
      .email(userRecord.email())
      .userName(userRecord.getRealUserName())
      .createdAt(LocalDateTime.now())
      .updatedAt(LocalDateTime.now())
      .build();
    newProfile = userRepository.save(newProfile);

    var finalNewProfile = newProfile;

    List<Document> sFiles = new ArrayList<>();
    for (MultipartFile file : files) {
      Document save = this.documentDomainService.save(file, finalNewProfile);
      sFiles.add(save);
    }
    return new BootstrapRecord(newProfile, sFiles);
  }
}
