package mx.gigabyte.labs.document.analyzer.domain.model.record;

import mx.gigabyte.labs.document.analyzer.domain.model.enums.DocumentStatus;
import mx.gigabyte.labs.document.analyzer.domain.model.enums.DocumentType;

public record DocumentRecord(long id, String documentName, String mimeType, String fileSize, DocumentType documentType, DocumentStatus documentStatus) {

}
