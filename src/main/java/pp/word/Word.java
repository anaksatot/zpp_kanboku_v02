package pp.word;

import pp.sentence.Sentence;
import pp.stringProcessing.XIvCharsetProcessing;

import javax.persistence.*;

/**
 * Created by Admin on 3/19/2017.
 */
@Entity
@Table (name= "words")
public class Word {

    private int id;
    private String word;
    private Sentence sentence;

    public Word() {

    }

    public Word(String word, Sentence sentence) {
        this.word = word;
        this.sentence = sentence;
    }
        @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "word", unique = false, nullable = false, length = 10)
    public String getWord() {
        return new XIvCharsetProcessing().getFirstXIvSystemOrthographyForm(this.word);
    }

    public void setWord(String word) {
        this.word = new XIvCharsetProcessing().convertFromFirstXIvSystemOrthographyForm(word);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sentence", nullable = false)
    public Sentence getSentence() {
        return sentence;
    }

    public void setSentence(Sentence sentence) {
        this.sentence = sentence;
    }
}