package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.PerfectOrImperfect;
import pp.grammaticalCategories.Pronoun;
import pp.grammaticalCategories.Time;
import pp.linguisticCategories.FormOfVerbPersonal;
import pp.linguisticCategories.FormsOfVerbPersonalConjugation;
import pp.linguisticCategories.LCDefineDimension;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Admin on 02.12.2016.
 */
public class FormsOfVerbPersonalConjugationServiceImpl {

    FormsOfVerbPersonalConjugation definePersonalForms(String word, boolean onlyThisForm) {
        if (!onlyThisForm) {
            System.out.println("Визначаємо всі форми дієслова");
            return definePersonalFormOfVerbAllForms(word);
        };
        return definePersonalVerbForm(word);
    }

    FormsOfVerbPersonalConjugation definePersonalVerbForm(String word) {
        FormOfVerbPersonal formOfVerbPersonal = new FormOfVerbPersonal(LCDefineDimension.definePerfectImperfect(),LCDefineDimension.defineTime(),LCDefineDimension.definePerson());
        return new FormsOfVerbPersonalConjugation(formOfVerbPersonal, word);
    }

    FormsOfVerbPersonalConjugation definePersonalFormOfVerbAllForms(String word) {
        HashMap<FormOfVerbPersonal, String> mapPersonalFormOfVerb = new HashMap<FormOfVerbPersonal, String>();
        mapPersonalFormOfVerb = loopThroughPerfectImperfectPersonalForm(mapPersonalFormOfVerb);
        return new FormsOfVerbPersonalConjugation(mapPersonalFormOfVerb);
    }

    HashMap<FormOfVerbPersonal, String> loopThroughPerfectImperfectPersonalForm(HashMap<FormOfVerbPersonal, String> mapPersonalFormOfVerb) {
        for (PerfectOrImperfect somePerfectImperfect: PerfectOrImperfect.values())  {
            mapPersonalFormOfVerb = loopThroughTimesPersonalForm(somePerfectImperfect,mapPersonalFormOfVerb);
        }
        return mapPersonalFormOfVerb;
    }

    HashMap<FormOfVerbPersonal, String> loopThroughTimesPersonalForm(PerfectOrImperfect somePerfectImperfect, HashMap<FormOfVerbPersonal, String> mapPersonalFormOfVerb) {
        for (Time someTime: Time.values()) {
            mapPersonalFormOfVerb = loopThroughPersonPersonalForm(somePerfectImperfect,someTime,mapPersonalFormOfVerb);
        }
        return mapPersonalFormOfVerb;
    }

    HashMap<FormOfVerbPersonal, String> loopThroughPersonPersonalForm(PerfectOrImperfect somePerfectImperfect, Time someTime, HashMap<FormOfVerbPersonal, String> mapPersonalFormOfVerb) {
        Scanner scannerWord = new Scanner(System.in);
        String word;
        for (Pronoun somePerson: Pronoun.values()) {
            word = scannerWord.nextLine();
            if (true) {
                mapPersonalFormOfVerb.put(new FormOfVerbPersonal(somePerfectImperfect,someTime,somePerson),word);
            }
        }
        return mapPersonalFormOfVerb;
    }
}
