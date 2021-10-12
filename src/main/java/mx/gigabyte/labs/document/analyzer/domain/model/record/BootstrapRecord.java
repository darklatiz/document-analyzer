package mx.gigabyte.labs.document.analyzer.domain.model.record;

import mx.gigabyte.labs.document.analyzer.domain.model.Document;
import mx.gigabyte.labs.document.analyzer.domain.model.User;

import java.util.List;

public record BootstrapRecord(User userRecord, List<Document> documentRecords) {
}
