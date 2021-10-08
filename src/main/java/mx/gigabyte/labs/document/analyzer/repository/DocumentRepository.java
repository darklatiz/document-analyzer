package mx.gigabyte.labs.document.analyzer.repository;

import mx.gigabyte.labs.document.analyzer.domain.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
