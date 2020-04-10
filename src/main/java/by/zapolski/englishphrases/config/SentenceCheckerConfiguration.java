package by.zapolski.englishphrases.config;

import by.zapolski.englishphrases.domain.WordWithFrequency;
import by.zapolski.englishphrases.repository.WordWithFrequencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SentenceCheckerConfiguration {
    @Autowired
    private WordWithFrequencyRepo wordWithFrequencyRepo;

    @Bean(name = "wordList")
    public List<WordWithFrequency> getAllWordsWithFrequency(){
        return wordWithFrequencyRepo.findAll();
    }

}
