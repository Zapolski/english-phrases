package by.zapolski.englishphrases.controller;

import by.zapolski.englishphrases.domain.SentenceInfo;
import by.zapolski.englishphrases.service.SentenceCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sentences/check")
public class SentenceCheckerController {

    @Autowired
    private SentenceCheckerService sentenceCheckerService;

    @PostMapping
    public SentenceInfo getSentenceRank(@RequestBody String sentence) {
        return sentenceCheckerService.getSentenceRank(sentence);
    }

}
