package mx.gigabyte.labs.document.analyzer.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditAwareImpl implements AuditorAware<String> {
  @Override
  public Optional<String> getCurrentAuditor() {
//    ApplicationUser principal = (ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    return Optional.of(principal.getId());
    return Optional.of("Luigi-TheGod");
  }
}
