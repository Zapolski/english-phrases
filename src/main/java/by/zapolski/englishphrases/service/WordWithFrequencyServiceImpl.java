package by.zapolski.englishphrases.service;

import by.zapolski.englishphrases.domain.WordWithFrequency;
import by.zapolski.englishphrases.domain.dto.WordWithFrequencyDto;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordWithFrequencyServiceImpl implements WordWithFrequencyService {

    @Autowired
    private List<WordWithFrequency> wordList;

    @Override
    public List<WordWithFrequencyDto> getSimilarWordsWithAccuracyThreshold(String word, Integer threshold) {
        List<WordWithFrequencyDto> result = new ArrayList<>();
        JaroWinklerSimilarity jaroWinklerSimilarity = new JaroWinklerSimilarity();

        for (WordWithFrequency wordWithFrequency : wordList) {
            Double currentThreshold = jaroWinklerSimilarity.apply(word, wordWithFrequency.getValue()) * 100;

            if (currentThreshold >= threshold) {
                WordWithFrequencyDto wordWithFrequencyDto = new WordWithFrequencyDto();

                wordWithFrequencyDto.setSimilarity(currentThreshold);
                wordWithFrequencyDto.setId(wordWithFrequency.getId());
                wordWithFrequencyDto.setPartOfSpeech(wordWithFrequency.getPartOfSpeech());
                wordWithFrequencyDto.setRank(wordWithFrequency.getRank());
                wordWithFrequencyDto.setValue(wordWithFrequency.getValue());

                result.add(wordWithFrequencyDto);
            }
        }
        return result.stream().sorted(
                Comparator.comparingDouble(WordWithFrequencyDto::getSimilarity)
                        .reversed()
                        .thenComparing(WordWithFrequencyDto::getRank)
        ).collect(Collectors.toList());
    }
}
