package pp.sentence;

import pp.textFileProcessing.TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr;
import pp.word.WordUniqueForm;
import pp.word.WordUniqueFormUkrainianServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SentenceServiceImplUkrainian implements SentenceService{

    @Override
    public List<Sentence> parsingTextIntoSentences(String textInOneString, Map<WordUniqueForm,Integer> wordsUniqueForm) {

        System.out.println("Start text parsing into Sentences!");
        List<String> textOfFileDivideOnListSentences = new TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr().readTextFromStringAndDivideIntoSentencesList(textInOneString);
        List<Sentence> listSentences = new ArrayList<Sentence>();
        for (String stSentence: textOfFileDivideOnListSentences) {
            listSentences.add(new Sentence(stSentence,new WordUniqueFormUkrainianServiceImpl().mapWordsOfCurrentTextStringKey(wordsUniqueForm)));
        }
        System.out.println("Finish text parsing into Sentences!");
        return listSentences;
    }
}
