package pp.word;

import org.json.simple.parser.ParseException;
import pp.linguisticCategories.Language;
import pp.linguisticCategories.LinguisticCategory;
import pp.linguisticCategories.LinguisticCategoryForms;
import pp.linguisticCategories.linguisticCategoriesService.*;
import pp.textFileProcessing.JsonFileReadAndWriteServiceImpl;
import pp.textFileProcessing.TextFileReadAndWriteServiceImpl;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordUniqueFormUkrainianServiceImpl implements WordUniqueFormService {

    public Map<WordUniqueForm,Integer>  parsingTextIntoUniqueWords(List<String> textOfFileDivideOnListWords) {

        System.out.println("Start text parsing into Unique Words!");
        final File folder = new File(TextFileReadAndWriteServiceImpl.directoryForSaveJSONfilesWordUniqueForm());
        JsonFileReadAndWriteServiceImpl jsonFileService = new JsonFileReadAndWriteServiceImpl();
        Map<String, WordUniqueForm> allWordUniqueForm = jsonFileService.getAllWordUniqueFormFromJSONfiles(folder);
        Map<WordUniqueForm,Integer> mapWordsOfCurrentText = listWordsOfCurrentTextAndCreateNewWordsUniqueForm(textOfFileDivideOnListWords, allWordUniqueForm);
        jsonFileService.saveStatisticToJsonFilesForCurrentText(mapWordsOfCurrentText);
         if (new XMLfileReadAndWriteServiceImpl().saveToXMLStatisticInformationCompleted()) {
            System.out.println("Finish Text parsing into Unique Words! Statistic is written!");
        }
        return mapWordsOfCurrentText;
    }

    private Map<WordUniqueForm,Integer> listWordsOfCurrentTextAndCreateNewWordsUniqueForm(List<String> textOfFileDivideOnListWords, Map<String, WordUniqueForm> allWordUniqueForm){
        WordUniqueForm wordUniqueForm;
        TextFileReadAndWriteServiceImpl textFileReadAndWriteServiceImpl = new TextFileReadAndWriteServiceImpl();
        Map<WordUniqueForm,Integer> listWordsOfCurrentText = new HashMap<WordUniqueForm,Integer>();
        for (String word : textOfFileDivideOnListWords) {
            if (!allWordUniqueForm.containsKey(word.toLowerCase())) {
                try {
                    wordUniqueForm = createNewWordUniqueForm(word, modeIsInDetail());
                    textFileReadAndWriteServiceImpl.writeToJSONfile(new JsonFileReadAndWriteServiceImpl().stringForJSONParserWordUniqueForm(wordUniqueForm), word);
                    allWordUniqueForm.put(wordUniqueForm.getFormOfWord(),wordUniqueForm);
                    listWordsOfCurrentText.put(wordUniqueForm,1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } else {
                wordUniqueForm = allWordUniqueForm.get(word.toLowerCase());
                wordUniqueForm.checkAndWriteFormsWithCapitalAndLowerLetters(word);
                if (!listWordsOfCurrentText.containsKey(wordUniqueForm)) {
                    listWordsOfCurrentText.put(wordUniqueForm,1);
                } else {
                    listWordsOfCurrentText.put(wordUniqueForm, listWordsOfCurrentText.get(wordUniqueForm) + 1);
                }
            }
        }
        return listWordsOfCurrentText;
    }

    public WordUniqueForm createNewWordUniqueForm(String word, boolean inDetail) {
        WordUniqueForm WordUniqueForm = new WordUniqueForm(word, Language.UKRAINIAN);
        ArrayList<LinguisticCategory> linguisticCategoriesOfWordUniqueForm = new ArrayList<LinguisticCategory>();
        Scanner scanner2 = new Scanner(System.in);

        while (true) {
            System.out.println("Визнаення слова: " + word);
            //System.out.println("Визнаення слова xivi system : " + firstXSystemOrthographyOfWord(word, Language.UKRAINIAN));
            //new LinguisticCategoriesServiceImpl().listOfLinguisticCategoryInUkrainianOut();
            //int n = scanner2.nextInt();
            int n = 1;
            switch (n) {
                case 1:
                    linguisticCategoriesOfWordUniqueForm.add(new LcNounUkrainianServiceImpl().defineLcNounUniqueForm(word,inDetail));
                    break;
                case 2:
                    linguisticCategoriesOfWordUniqueForm.add(new LcVerbUkrainianServiceImpl().defineLcVerbUniqueForm(word,inDetail));
                    break;
                case 3:
                    linguisticCategoriesOfWordUniqueForm.add(new LcAdverbUkrainianServiceImpl().defineLcAdverb(word));
                    //System.out.println(new LcAdverbUkrainianServiceImpl().defineLcAdverb(word).toString());
                    break;
                case 4:
                    linguisticCategoriesOfWordUniqueForm.add(new LcAdjectiveUkrainianServiceImpl().defineLcAdjective(word));
                    //System.out.println(new LcAdjectiveUkrainianServiceImpl().defineLcAdjective(word).toString());
                    break;
                case 5:
                    linguisticCategoriesOfWordUniqueForm.add(new LcPronounUkrainianServiceImpl().defineLcPronoun(word));
                    //System.out.println(new LcPronounUkrainianServiceImpl().defineLcPronoun(word).toString());
                    break;
                case 6:
                    linguisticCategoriesOfWordUniqueForm.add(new LcPrerositionUkrainianServiceImpl().defineLcPrerosition(word));
                    //System.out.println(new LcPrerositionUkrainianServiceImpl().defineLcPrerosition(word).toString());
                    break;
                case 7:
                    linguisticCategoriesOfWordUniqueForm.add(new LcConjunctionUkrainianServiceImpl().defineLcConjunction(word));
                    //System.out.println(new LcConjunctionUkrainianServiceImpl().defineLcConjunction(word).toString());
                    break;
                case 8:
                    linguisticCategoriesOfWordUniqueForm.add(new LcNumeralUkrainianServiceImpl().defineLcNumeral(word));
                    //System.out.println(new LcNumeralUkrainianServiceImpl().defineLcNumeral(word).toString());
                    break;
                default:
                    System.out.println("некоректний номер частини мови! спробуйте ще раз!");
                    continue;
            }
            break;
        }
        WordUniqueForm.setLinguisticCategoryForms(new LinguisticCategoryForms(linguisticCategoriesOfWordUniqueForm));
        return WordUniqueForm;
    }

    public Map<String,WordUniqueForm> mapWordsOfCurrentTextStringKey(Map<WordUniqueForm, Integer> mapWordsOfCurrentText){
        Map<String,WordUniqueForm> mapWordsOfCurrentTextNewStructure =new HashMap<String, WordUniqueForm>();
        for (WordUniqueForm  keyWordUniqueForm : mapWordsOfCurrentText.keySet()) {
            mapWordsOfCurrentTextNewStructure.put(keyWordUniqueForm.getFormOfWord(),keyWordUniqueForm);
        }
        return mapWordsOfCurrentTextNewStructure;
    }

    public boolean modeIsInDetail() {
        return false;
//        System.out.println("Визначати слова детально (з відмінками, числами та родами) чи текучу форму?");
//        System.out.println("Якщо детально то введіть з клавіатури 'y', інакше введіть 'n'");
//        while (true) {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            try
//            {
//                int ascii = br.read();
//                System.out.println(" Value - "+ascii);
//                if (ascii == 121) {
//                    return true;
//                }
//                if (ascii == 110) {
//                    return false;
//                }
//                System.out.println("спробуйте ввести ще раз!");
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
    }

    public boolean wordIsNotCorrect(String word) {

        System.out.println(word.toUpperCase() + " Якщо слово коректне просто натисніть Enter. Якщо некоректне тоді любу клавішу з літерою і тоді Enter");
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                int ascii = br.read();
                System.out.println(" Value - "+ascii);
                if (ascii == 10) {
                    return false;
                }
                return true;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return true;
        }
    }

}
