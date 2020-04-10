package by.zapolski.englishphrases.controller;

import by.zapolski.englishphrases.domain.dto.WordWithFrequencyDto;
import by.zapolski.englishphrases.service.WordWithFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("words/frequency")
public class WordWithFrequencyController {

    @Autowired
    private WordWithFrequencyService wordWithFrequencyService;

    @GetMapping
    public List<WordWithFrequencyDto> getSimilarWordsWithAccuracyThreshold(
            @RequestParam String word,
            @RequestParam Integer threshold
    ) {
        return wordWithFrequencyService.getSimilarWordsWithAccuracyThreshold(word, threshold);
    }
}
