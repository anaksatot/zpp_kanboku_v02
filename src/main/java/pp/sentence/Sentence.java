package pp.sentence;

import pp.stringProcessing.XIvCharsetProcessing;
import pp.textFileProcessing.TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr;
import pp.word.Word;
import pp.word.WordUniqueForm;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Admin on 3/17/2017.
 */
@Entity
@Table (name= "sentence")
public class Sentence {

    private int id;
    //@Column(name= "dumka")
    private String dumka;
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "sentence")
    private List<Word> listWords;
    private Map<WordUniqueForm,Integer> wordsUniqueFormInSentence;
    public Sentence(String stSentence, Map<String, WordUniqueForm> mapWordsOfCurrentText) {
        this.dumka = stSentence;
        List<String> listWordsInSentence = new TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr().readTextFromStringAndDivideOnWordsList(stSentence);
        listWords = new ArrayList<Word>();
        wordsUniqueFormInSentence = new HashMap<WordUniqueForm, Integer>();
        for (String word:listWordsInSentence) {
            listWords.add(new Word(word.toLowerCase(),this));
            if (!wordsUniqueFormInSentence.containsKey(mapWordsOfCurrentText.get(word.toLowerCase()))) {
                wordsUniqueFormInSentence.put(mapWordsOfCurrentText.get(word.toLowerCase()),1);
            } else {
                wordsUniqueFormInSentence.put(mapWordsOfCurrentText.get(word.toLowerCase()), wordsUniqueFormInSentence.get(mapWordsOfCurrentText.get(word.toLowerCase()))+ 1);
            }
        }
    }

    public Sentence() {
    }

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name= "dumka")
    public String getDumka() {
        return new XIvCharsetProcessing().getFirstXIvSystemOrthographyForm(dumka);
    }

    public void setDumka(String dumka) {
        this.dumka = dumka;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sentence")
    public List<Word> getListWords() {
        return listWords;
    }

    public void setListWords(List<Word> listWords) {
        this.listWords = listWords;
    }

    @Transient
    public Map<WordUniqueForm, Integer> getWordsUniqueFormInSentence() {
        return wordsUniqueFormInSentence;
    }


}
