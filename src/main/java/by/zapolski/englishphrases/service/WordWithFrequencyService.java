package by.zapolski.englishphrases.service;

import by.zapolski.englishphrases.domain.dto.WordWithFrequencyDto;

import java.util.List;

public interface WordWithFrequencyService {
    List<WordWithFrequencyDto> getSimilarWordsWithAccuracyThreshold(String word, Integer threshold);
}
