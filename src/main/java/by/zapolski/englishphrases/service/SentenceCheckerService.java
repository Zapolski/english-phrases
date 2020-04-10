package by.zapolski.englishphrases.service;

import by.zapolski.englishphrases.domain.SentenceInfo;

public interface SentenceCheckerService {

    SentenceInfo getSentenceRank(String sentence);
}
