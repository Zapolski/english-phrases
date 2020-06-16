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
    @SequenceGenerator( name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    private Long id;
    private String value;
    private Integer rank;
    private Character partOfSpeech;
}
