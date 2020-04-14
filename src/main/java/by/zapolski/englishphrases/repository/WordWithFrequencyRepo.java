package by.zapolski.englishphrases.repository;

import by.zapolski.englishphrases.domain.WordWithFrequency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordWithFrequencyRepo extends JpaRepository<WordWithFrequency,Long> {
    List<WordWithFrequency> findByValue(String value);
}
