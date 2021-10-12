package mx.gigabyte.labs.document.analyzer.domain;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import mx.gigabyte.labs.document.analyzer.domain.exception.DocumentException;
import mx.gigabyte.labs.document.analyzer.domain.model.record.BootstrapRecord;
import mx.gigabyte.labs.document.analyzer.domain.model.record.UserRecord;

import mx.gigabyte.labs.document.analyzer.factory.DocumentFactory;
import mx.gigabyte.labs.document.analyzer.web.rest.request.BootstrapCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Log4j2
@Getter
public class DocumentAnalyzerApplicationService {

  private final DocumentFactory documentFactory;

  @Autowired
  public DocumentAnalyzerApplicationService(DocumentFactory documentFactory) {
    this.documentFactory = documentFactory;
  }

  public BootstrapRecord boostrap(BootstrapCommand bootstrapCommand, List<MultipartFile> files) throws DocumentException {
    log.info("Bootstrapping Documents...");

    UserRecord userRecord = new UserRecord(
      bootstrapCommand.getUserInfo().getName(),
      bootstrapCommand.getUserInfo().getLastName(),
      bootstrapCommand.getUserInfo().getEmail(),
      bootstrapCommand.getUserInfo().getUserName(),
      bootstrapCommand.getUserInfo().isUserNameSameAsEmail()
    );

    return documentFactory.bootStrap(userRecord, files);
  }

}
