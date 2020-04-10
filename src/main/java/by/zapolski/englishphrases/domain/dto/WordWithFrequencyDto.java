package by.zapolski.englishphrases.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
public class WordWithFrequencyDto {
    private Long id;
    private String value;
    private Integer rank;
    private Character partOfSpeech;
    private Double similarity;
}
