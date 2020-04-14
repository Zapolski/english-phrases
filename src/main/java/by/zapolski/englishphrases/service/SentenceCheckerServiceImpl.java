package by.zapolski.englishphrases.service;

import by.zapolski.englishphrases.domain.SentenceInfo;
import by.zapolski.englishphrases.domain.WordWithFrequency;
import by.zapolski.englishphrases.repository.WordWithFrequencyRepo;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.TokenizerME;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SentenceCheckerServiceImpl implements SentenceCheckerService {

    @Autowired
    private TokenizerME tokenizer;
    @Autowired
    private POSTaggerME tagger;
    @Autowired
    private DictionaryLemmatizer lemmatizer;

    @Autowired
    private WordWithFrequencyRepo wordWithFrequencyRepo;

    @Override
    public SentenceInfo getSentenceRank(String sentence) {
        SentenceInfo sentenceInfo = new SentenceInfo();

        sentenceInfo.setTokens(tokenizer.tokenize(sentence));
        sentenceInfo.setTags(tagger.tag(sentenceInfo.getTokens()));
        sentenceInfo.setLemmas(lemmatizer.lemmatize(sentenceInfo.getTokens(), sentenceInfo.getTags()));
        sentenceInfo.setSource(sentence);

        Integer[] ranks = new Integer[sentenceInfo.getLemmas().length];

        int rank;
        int index = 0;
        for (String lemma : sentenceInfo.getLemmas()) {
            if (!"O".equals(lemma)) {
                List<WordWithFrequency> wordList = wordWithFrequencyRepo.findByValue(lemma);
                Optional<WordWithFrequency> optional = wordList.stream().min(Comparator.comparingInt(WordWithFrequency::getRank));
                int currentRank = optional.isPresent() ? optional.get().getRank() : 0;
                ranks[index] = currentRank;
            }
            index++;
        }

        if (Arrays.stream(ranks).filter(Objects::nonNull).anyMatch(value -> value == 0)) {
            rank = 0;
        } else {
            rank = Arrays.stream(ranks).filter(Objects::nonNull).max(Integer::compareTo).orElse(0);
        }

        sentenceInfo.setRanks(ranks);
        sentenceInfo.setRank(rank);
        return sentenceInfo;
    }


}
