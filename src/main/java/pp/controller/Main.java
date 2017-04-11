package pp.controller;
import org.json.simple.parser.ParseException;
import pp.databaseProcessing.ManageSentence;
import pp.linguisticCategories.Language;
import pp.sentence.Sentence;
import pp.sentence.SentenceServiceImplUkrainian;
import pp.text.TextMask;
import pp.textFileProcessing.TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr;
import pp.textFileProcessing.TextFileImproveService;
import pp.textFileProcessing.TextFileImproveServiceImpl;
import pp.textFileProcessing.TextFileReadAndWriteServiceImpl;
import pp.word.WordUniqueForm;
import pp.word.WordUniqueFormUkrainianServiceImpl;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        XMLfileReadAndWriteServiceImpl.defineSystemParameters();
        //String pathToFile = new TextFileReadAndWriteServiceImpl().pathToTXTFile();
        String pathToFile = "e:\\TextForAnalys2_2.txt";
        Map<WordUniqueForm,Integer> mapWordsOfCurrentText = null;
        String textInOneString= "";
        TextFileImproveService textFileImprove = new TextFileImproveServiceImpl();
        if (textFileImprove.fileExist(pathToFile) && textFileImprove.fileIsTXT(pathToFile)) {
            textInOneString = new TextFileReadAndWriteServiceImpl().read(pathToFile);
            TextMask uniqueIndexOfTXTfile = textFileImprove.uniqueMaskOfTXTfile(textInOneString,pathToFile);
            if (uniqueIndexOfTXTfile.isNewCurrentTextMask()) {
                List<String> textOfFileDivideOnListWords = new TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr().readTextFromStringAndDivideOnWordsList(textInOneString);
                mapWordsOfCurrentText = new WordUniqueFormUkrainianServiceImpl().parsingTextIntoUniqueWords(textOfFileDivideOnListWords);
                List<Sentence> listSentences = new SentenceServiceImplUkrainian().parsingTextIntoSentences(textInOneString, mapWordsOfCurrentText);
//                ManageSentence manageSentence = new ManageSentence();
//                for (Sentence sentence:listSentences) {
//                     manageSentence.addSentence(sentence, Language.UKRAINIAN);
//                 }
                new TextFileReadAndWriteServiceImpl().writeNewTextIntoFilesDB(pathToFile,uniqueIndexOfTXTfile.getIndex(),mapWordsOfCurrentText);
                XMLfileReadAndWriteServiceImpl.saveToXMLnewTextMaskCurrent(uniqueIndexOfTXTfile);
            } else {
                System.out.println("File "+pathToFile+" is already processed!");
            }
       }
        System.out.println(mapWordsOfCurrentText);
    }
}
