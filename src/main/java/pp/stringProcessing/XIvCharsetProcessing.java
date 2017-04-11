package pp.stringProcessing;

import pp.linguisticCategories.Language;

/**
 * Created by Admin on 3/24/2017.
 */
public class XIvCharsetProcessing {
    //private XIvCharsetProcessing(){};
//    public static  String firstXSystemOrthographyOfWord_old(String word, Language language) {
//        switch (language) {
//            case UKRAINIAN:
//                return new FirstXSystemOrthographyUkrainian().getFirstXSystemOrthographyForm(word);
//            case ENGLISH:
//                return new FirstXSystemOrthographyEnglish().getFirstXSystemOrthographyForm(word);
//            case GERMANY:
//                return new FirstXSystemOrthographyGermany().getFirstXSystemOrthographyForm(word);
//        }
//        return "";
//    }

    public static  String firstXIvSystemOrthographyOfWord(String word, Language language) {
        switch (language) {
            case UKRAINIAN:
                return getFirstXIvSystemOrthographyForm(word);
            case ENGLISH:
                return getFirstXIvSystemOrthographyForm(word);
            case GERMANY:
                return getFirstXIvSystemOrthographyForm(word);
        }
        return "";
    }

    public static String getFirstXIvSystemOrthographyForm(String word) {

        word = word.replace(new String(Character.toChars(1044))+new String(Character.toChars(1079)),new String(Character.toChars(68))+new String(Character.toChars(122))); // Дз
        word = word.replace(new String(Character.toChars(1044))+new String(Character.toChars(1078)),new String(Character.toChars(68))+new String(Character.toChars(120))+new String(Character.toChars(103))); // Дж
        word = word.replace(new String(Character.toChars(1040)),new String(Character.toChars(65)));
        word = word.replace(new String(Character.toChars(1041)),new String(Character.toChars(66)));
        word = word.replace(new String(Character.toChars(1042)),new String(Character.toChars(86)));
        word = word.replace(new String(Character.toChars(1043)),new String(Character.toChars(120))+new String(Character.toChars(72)));
        word = word.replace(new String(Character.toChars(1168)),new String(Character.toChars(71)));
        word = word.replace(new String(Character.toChars(1044)),new String(Character.toChars(68)));
        word = word.replace(new String(Character.toChars(1045)),new String(Character.toChars(69)));
        word = word.replace(new String(Character.toChars(1046)),new String(Character.toChars(120))+new String(Character.toChars(90)));
        word = word.replace(new String(Character.toChars(1047)),new String(Character.toChars(90)));
        word = word.replace(new String(Character.toChars(1048)),new String(Character.toChars(89)));
        word = word.replace(new String(Character.toChars(1049)),new String(Character.toChars(74)));
        word = word.replace(new String(Character.toChars(1050)),new String(Character.toChars(75)));
        word = word.replace(new String(Character.toChars(1051)),new String(Character.toChars(76)));
        word = word.replace(new String(Character.toChars(1052)),new String(Character.toChars(77)));
        word = word.replace(new String(Character.toChars(1053)),new String(Character.toChars(78)));
        word = word.replace(new String(Character.toChars(1054)),new String(Character.toChars(79)));
        word = word.replace(new String(Character.toChars(1055)),new String(Character.toChars(80)));
        word = word.replace(new String(Character.toChars(1056)),new String(Character.toChars(82)));
        word = word.replace(new String(Character.toChars(1057)),new String(Character.toChars(83)));
        word = word.replace(new String(Character.toChars(1058)),new String(Character.toChars(84)));
        word = word.replace(new String(Character.toChars(1059)),new String(Character.toChars(85)));
        word = word.replace(new String(Character.toChars(1060)),new String(Character.toChars(70)));
        word = word.replace(new String(Character.toChars(1061)),new String(Character.toChars(72)));
        word = word.replace(new String(Character.toChars(1062)),new String(Character.toChars(67)));
        word = word.replace(new String(Character.toChars(1063)),new String(Character.toChars(120))+new String(Character.toChars(67)));
        word = word.replace(new String(Character.toChars(1064)),new String(Character.toChars(120))+new String(Character.toChars(83)));
        word = word.replace(new String(Character.toChars(1065)),new String(Character.toChars(120))+new String(Character.toChars(83))+new String(Character.toChars(120))+new String(Character.toChars(99)));
        word = word.replace(new String(Character.toChars(1068)),new String(Character.toChars(126)));
        word = word.replace(new String(Character.toChars(1070)),new String(Character.toChars(74))+new String(Character.toChars(117)));
        word = word.replace(new String(Character.toChars(1071)),new String(Character.toChars(74))+new String(Character.toChars(97)));
        word = word.replace(new String(Character.toChars(1028)),new String(Character.toChars(74))+new String(Character.toChars(101)));
        word = word.replace(new String(Character.toChars(1030)),new String(Character.toChars(73)));
        word = word.replace(new String(Character.toChars(1031)),new String(Character.toChars(74))+new String(Character.toChars(105)));
        //
        word = word.replace(new String(Character.toChars(1076))+new String(Character.toChars(1079)),new String(Character.toChars(100))+new String(Character.toChars(122))); // Дз
        word = word.replace(new String(Character.toChars(1076))+new String(Character.toChars(1078)),new String(Character.toChars(100))+new String(Character.toChars(120))+new String(Character.toChars(103))); // Дж
        word = word.replace(new String(Character.toChars(1072)),new String(Character.toChars(97)));
        word = word.replace(new String(Character.toChars(1073)),new String(Character.toChars(98)));
        word = word.replace(new String(Character.toChars(1074)),new String(Character.toChars(118)));
        word = word.replace(new String(Character.toChars(1075)),new String(Character.toChars(120))+new String(Character.toChars(104)));
        word = word.replace(new String(Character.toChars(1169)),new String(Character.toChars(103)));
        word = word.replace(new String(Character.toChars(1076)),new String(Character.toChars(100)));
        word = word.replace(new String(Character.toChars(1077)),new String(Character.toChars(101)));
        word = word.replace(new String(Character.toChars(1078)),new String(Character.toChars(120))+new String(Character.toChars(122)));
        word = word.replace(new String(Character.toChars(1079)),new String(Character.toChars(122)));
        word = word.replace(new String(Character.toChars(1080)),new String(Character.toChars(121)));
        word = word.replace(new String(Character.toChars(1081)),new String(Character.toChars(106)));
        word = word.replace(new String(Character.toChars(1082)),new String(Character.toChars(107)));
        word = word.replace(new String(Character.toChars(1083)),new String(Character.toChars(108)));
        word = word.replace(new String(Character.toChars(1084)),new String(Character.toChars(109)));
        word = word.replace(new String(Character.toChars(1085)),new String(Character.toChars(110)));
        word = word.replace(new String(Character.toChars(1086)),new String(Character.toChars(111)));
        word = word.replace(new String(Character.toChars(1087)),new String(Character.toChars(112)));
        word = word.replace(new String(Character.toChars(1088)),new String(Character.toChars(114)));
        word = word.replace(new String(Character.toChars(1089)),new String(Character.toChars(115)));
        word = word.replace(new String(Character.toChars(1090)),new String(Character.toChars(116)));
        word = word.replace(new String(Character.toChars(1091)),new String(Character.toChars(117)));
        word = word.replace(new String(Character.toChars(1092)),new String(Character.toChars(102)));
        word = word.replace(new String(Character.toChars(1093)),new String(Character.toChars(104)));
        word = word.replace(new String(Character.toChars(1094)),new String(Character.toChars(99)));
        word = word.replace(new String(Character.toChars(1095)),new String(Character.toChars(120))+new String(Character.toChars(99)));
        word = word.replace(new String(Character.toChars(1096)),new String(Character.toChars(120))+new String(Character.toChars(115)));
        word = word.replace(new String(Character.toChars(1097)),new String(Character.toChars(120))+new String(Character.toChars(115))+new String(Character.toChars(120))+new String(Character.toChars(99)));
        word = word.replace(new String(Character.toChars(1100)),new String(Character.toChars(126)));
        word = word.replace(new String(Character.toChars(1102)),new String(Character.toChars(106))+new String(Character.toChars(117)));
        word = word.replace(new String(Character.toChars(1103)),new String(Character.toChars(106))+new String(Character.toChars(97)));
        word = word.replace(new String(Character.toChars(1108)),new String(Character.toChars(106))+new String(Character.toChars(101)));
        word = word.replace(new String(Character.toChars(1110)),new String(Character.toChars(105)));
        word = word.replace(new String(Character.toChars(1111)),new String(Character.toChars(106))+new String(Character.toChars(105)));
        return word;
    }

    public static String convertFromFirstXIvSystemOrthographyForm(String word) {

        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(83))+new String(Character.toChars(120))+new String(Character.toChars(99)),new String(Character.toChars(1065)));
        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(67)),new String(Character.toChars(1063)));
        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(83)),new String(Character.toChars(1064)));
        word = word.replace(new String(Character.toChars(68))+new String(Character.toChars(122)),new String(Character.toChars(1044))+new String(Character.toChars(1079))); // Дз
        word = word.replace(new String(Character.toChars(68))+new String(Character.toChars(120))+new String(Character.toChars(103)),new String(Character.toChars(1044))+new String(Character.toChars(1078))); // Дж
        word = word.replace(new String(Character.toChars(74))+new String(Character.toChars(117)),new String(Character.toChars(1070)));
        word = word.replace(new String(Character.toChars(74))+new String(Character.toChars(97)),new String(Character.toChars(1071)));
        word = word.replace(new String(Character.toChars(74))+new String(Character.toChars(101)),new String(Character.toChars(1028)));
        word = word.replace(new String(Character.toChars(74))+new String(Character.toChars(105)),new String(Character.toChars(1031)));
        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(72)),new String(Character.toChars(1043)));
        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(90)),new String(Character.toChars(1046)));
        word = word.replace(new String(Character.toChars(65)),new String(Character.toChars(1040)));
        word = word.replace(new String(Character.toChars(66)),new String(Character.toChars(1041)));
        word = word.replace(new String(Character.toChars(86)),new String(Character.toChars(1042)));
        word = word.replace(new String(Character.toChars(71)),new String(Character.toChars(1168)));
        word = word.replace(new String(Character.toChars(68)),new String(Character.toChars(1044)));
        word = word.replace(new String(Character.toChars(69)),new String(Character.toChars(1045)));
        word = word.replace(new String(Character.toChars(90)),new String(Character.toChars(1047)));
        word = word.replace(new String(Character.toChars(89)),new String(Character.toChars(1048)));
        word = word.replace(new String(Character.toChars(74)),new String(Character.toChars(1049)));
        word = word.replace(new String(Character.toChars(75)),new String(Character.toChars(1050)));
        word = word.replace(new String(Character.toChars(76)),new String(Character.toChars(1051)));
        word = word.replace(new String(Character.toChars(77)),new String(Character.toChars(1052)));
        word = word.replace(new String(Character.toChars(78)),new String(Character.toChars(1053)));
        word = word.replace(new String(Character.toChars(79)),new String(Character.toChars(1054)));
        word = word.replace(new String(Character.toChars(80)),new String(Character.toChars(1055)));
        word = word.replace(new String(Character.toChars(82)),new String(Character.toChars(1056)));
        word = word.replace(new String(Character.toChars(83)),new String(Character.toChars(1057)));
        word = word.replace(new String(Character.toChars(84)),new String(Character.toChars(1058)));
        word = word.replace(new String(Character.toChars(85)),new String(Character.toChars(1059)));
        word = word.replace(new String(Character.toChars(70)),new String(Character.toChars(1060)));
        word = word.replace(new String(Character.toChars(72)),new String(Character.toChars(1061)));
        word = word.replace(new String(Character.toChars(67)),new String(Character.toChars(1062)));
        word = word.replace(new String(Character.toChars(126)),new String(Character.toChars(1100))); // 1068 - 1100
        word = word.replace(new String(Character.toChars(73)),new String(Character.toChars(1030)));

        //
        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(115))+new String(Character.toChars(120))+new String(Character.toChars(99)),new String(Character.toChars(1097)));
        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(99)),new String(Character.toChars(1095)));
        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(115)),new String(Character.toChars(1096)));
        word = word.replace(new String(Character.toChars(106))+new String(Character.toChars(117)),new String(Character.toChars(1102)));
        word = word.replace(new String(Character.toChars(106))+new String(Character.toChars(97)),new String(Character.toChars(1103)));
        word = word.replace(new String(Character.toChars(106))+new String(Character.toChars(101)),new String(Character.toChars(1108)));
        word = word.replace(new String(Character.toChars(106))+new String(Character.toChars(105)),new String(Character.toChars(1111)));
        word = word.replace(new String(Character.toChars(100))+new String(Character.toChars(122)),new String(Character.toChars(1076))+new String(Character.toChars(1079))); // Дз
        word = word.replace(new String(Character.toChars(100))+new String(Character.toChars(120))+new String(Character.toChars(103)),new String(Character.toChars(1076))+new String(Character.toChars(1078))); // Дж
        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(104)),new String(Character.toChars(1075)));
        word = word.replace(new String(Character.toChars(120))+new String(Character.toChars(122)),new String(Character.toChars(1078)));
        word = word.replace(new String(Character.toChars(97)),new String(Character.toChars(1072)));
        word = word.replace(new String(Character.toChars(98)),new String(Character.toChars(1073)));
        word = word.replace(new String(Character.toChars(118)),new String(Character.toChars(1074)));
        word = word.replace(new String(Character.toChars(103)),new String(Character.toChars(1169)));
        word = word.replace(new String(Character.toChars(100)),new String(Character.toChars(1076)));
        word = word.replace(new String(Character.toChars(101)),new String(Character.toChars(1077)));
        word = word.replace(new String(Character.toChars(122)),new String(Character.toChars(1079)));
        word = word.replace(new String(Character.toChars(121)),new String(Character.toChars(1080)));
        word = word.replace(new String(Character.toChars(106)),new String(Character.toChars(1081)));
        word = word.replace(new String(Character.toChars(107)),new String(Character.toChars(1082)));
        word = word.replace(new String(Character.toChars(108)),new String(Character.toChars(1083)));
        word = word.replace(new String(Character.toChars(109)),new String(Character.toChars(1084)));
        word = word.replace(new String(Character.toChars(110)),new String(Character.toChars(1085)));
        word = word.replace(new String(Character.toChars(111)),new String(Character.toChars(1086)));
        word = word.replace(new String(Character.toChars(112)),new String(Character.toChars(1087)));
        word = word.replace(new String(Character.toChars(114)),new String(Character.toChars(1088)));
        word = word.replace(new String(Character.toChars(115)),new String(Character.toChars(1089)));
        word = word.replace(new String(Character.toChars(116)),new String(Character.toChars(1090)));
        word = word.replace(new String(Character.toChars(117)),new String(Character.toChars(1091)));
        word = word.replace(new String(Character.toChars(102)),new String(Character.toChars(1092)));
        word = word.replace(new String(Character.toChars(104)),new String(Character.toChars(1093)));
        word = word.replace(new String(Character.toChars(99)),new String(Character.toChars(1094)));
        word = word.replace(new String(Character.toChars(126)),new String(Character.toChars(1100)));
        word = word.replace(new String(Character.toChars(105)),new String(Character.toChars(1110)));

        return word;
    }

}
