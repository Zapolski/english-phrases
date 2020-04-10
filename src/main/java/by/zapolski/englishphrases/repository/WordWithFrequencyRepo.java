package by.zapolski.englishphrases.repository;

import by.zapolski.englishphrases.domain.WordWithFrequency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordWithFrequencyRepo extends JpaRepository<WordWithFrequency,Long> {
}
