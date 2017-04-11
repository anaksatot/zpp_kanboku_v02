package pp.word;
import pp.linguisticCategories.Language;

import java.util.List;
import java.util.Map;

public interface WordUniqueFormService {
	Map<WordUniqueForm,Integer> parsingTextIntoUniqueWords(List<String> textOfFileDivideOnListWords);
}
