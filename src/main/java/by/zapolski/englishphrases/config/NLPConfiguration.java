package by.zapolski.englishphrases.config;

import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class NLPConfiguration {

    @Bean
    public TokenizerME getTokenizerME() throws IOException {
        InputStream inputStream = getClass()
                .getResourceAsStream("/models/en-token.bin");
        TokenizerModel model = new TokenizerModel(inputStream);
        return new TokenizerME(model);
    }

    @Bean
    public POSTaggerME getPosTaggerME() throws IOException {
        InputStream inputStreamPOSTagger = getClass()
                .getResourceAsStream("/models/en-pos-maxent.bin");
        POSModel posModel = new POSModel(inputStreamPOSTagger);
        return new POSTaggerME(posModel);
    }

    @Bean
    public DictionaryLemmatizer getLemmatizer() throws IOException {
        InputStream dictLemmatizer = getClass()
                .getResourceAsStream("/models/en-lemmatizer.dict");
        return new DictionaryLemmatizer(
                dictLemmatizer);
    }
}
