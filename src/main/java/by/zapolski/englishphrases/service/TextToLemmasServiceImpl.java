package by.zapolski.englishphrases.service;

import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.tokenize.TokenizerME;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TextToLemmasServiceImpl implements TextToLemmasService{

    @Autowired
    private SentenceDetectorME sentenceDetectorME;

    @Autowired
    private TokenizerME tokenizer;

    @Autowired
    private POSTaggerME tagger;

    @Autowired
    private DictionaryLemmatizer lemmatizer;

    @Override
    public Set<String> getUniqueLemmasFromText(String text) {
        Set<String> resultSet = new HashSet<>();

        String[] sentences = sentenceDetectorME.sentDetect(text);
        for (String sentence : sentences){
            String[] tokens = tokenizer.tokenize(sentence);
            resultSet.addAll(Arrays.asList(lemmatizer.lemmatize(tokens, tagger.tag(tokens))));
        }

        resultSet.remove("O");

        return resultSet;
    }
}
