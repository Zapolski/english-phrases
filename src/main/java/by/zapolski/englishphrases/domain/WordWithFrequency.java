package by.zapolski.englishphrases.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Table
@Entity
@Data
@EqualsAndHashCode(of={"id"})
public class WordWithFrequency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
    private Integer rank;
    private Character partOfSpeech;
}
