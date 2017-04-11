package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.PartOfSpeech;
import pp.linguisticCategories.LcPronoun;
import pp.linguisticCategories.LcPronounUkrainian;

/**
 * Created by Admin on 09.12.2016.
 */
public class LcPronounUkrainianServiceImpl {
    public LcPronoun defineLcPronoun(String word) {
        return  new LcPronounUkrainian(PartOfSpeech.PRONOUN,word);
    }
}
