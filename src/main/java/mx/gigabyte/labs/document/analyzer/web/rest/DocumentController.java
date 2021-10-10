package mx.gigabyte.labs.document.analyzer.web.rest;

import lombok.extern.log4j.Log4j2;
import mx.gigabyte.labs.document.analyzer.domain.DocumentAnalyzerApplicationService;
import mx.gigabyte.labs.document.analyzer.web.rest.request.BootstrapCommand;
import mx.gigabyte.labs.document.analyzer.web.rest.response.DocumentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/document/analyzer")
@Log4j2
public class DocumentController {

  private DocumentAnalyzerApplicationService documentAnalyzerApplicationService;

  @Autowired
  public DocumentController(DocumentAnalyzerApplicationService documentAnalyzerApplicationService) {
    this.documentAnalyzerApplicationService = documentAnalyzerApplicationService;
  }

  @PostMapping(value = "bootstrap", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public @ResponseBody DocumentResponse create(@RequestPart("user_info") BootstrapCommand documentCommand, @RequestPart("file") List<MultipartFile> files) {
    log.info(documentCommand);
    files.forEach(log::info);

    documentAnalyzerApplicationService.boostrap(documentCommand, files);

    return DocumentResponse.builder()
      .code(200)
      .message("Prueba...")
      .build();
  }


}
