package by.zapolski.englishphrases.domain;

import lombok.Data;

@Data
public class SentenceInfo {
    private String source;
    private String[] tokens;
    private String[] tags;
    private String[] lemmas;
    private Integer[] ranks;
    private Integer rank;
}
