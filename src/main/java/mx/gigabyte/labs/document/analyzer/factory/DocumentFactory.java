package mx.gigabyte.labs.document.analyzer.factory;

import lombok.extern.slf4j.Slf4j;
import mx.gigabyte.labs.document.analyzer.domain.model.User;
import mx.gigabyte.labs.document.analyzer.domain.model.record.UserRecord;
import mx.gigabyte.labs.document.analyzer.repository.DocumentRepository;
import mx.gigabyte.labs.document.analyzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class DocumentFactory {

  private DocumentRepository documentRepository;
  private UserRepository userRepository;


  @Autowired
  public DocumentFactory(DocumentRepository documentRepository, UserRepository userRepository) {
    this.documentRepository = documentRepository;
    this.userRepository = userRepository;
  }

  public User createProfile(UserRecord userRecord) {
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
    return newProfile;
  }


  public void createDocuments(User profile, List<MultipartFile> files) {

  }
}
