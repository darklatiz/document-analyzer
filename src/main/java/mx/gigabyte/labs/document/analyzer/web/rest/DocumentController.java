package mx.gigabyte.labs.document.analyzer.web.rest;

import lombok.extern.log4j.Log4j2;
import mx.gigabyte.labs.document.analyzer.web.rest.request.DocumentCommand;
import mx.gigabyte.labs.document.analyzer.web.rest.response.DocumentResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/document")
@Log4j2
public class DocumentController {

  @PostMapping("create")
  public @ResponseBody DocumentResponse create(@RequestBody DocumentCommand documentCommand) {
    return null;
  }


}
