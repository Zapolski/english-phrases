package by.zapolski.englishphrases.repository;

import by.zapolski.englishphrases.domain.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepo extends JpaRepository<Rule,Long> {
}
