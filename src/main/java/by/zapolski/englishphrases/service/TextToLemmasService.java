package by.zapolski.englishphrases.service;

import java.util.Set;

public interface TextToLemmasService {

    Set<String> getUniqueLemmasFromText(String text);

}
