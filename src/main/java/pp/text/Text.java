package pp.text;

/**
 * Created by Admin on 3/31/2017.
 */
public class Text {

    String pathToFileInKanboku;
    String nameOfFile;
    String textInOneString;

    private class UniqueMaskOfText{
        String index;
        String firstHundredCharacters;
        int lengthOfFileInOneString;
        String nameOfFile;

        public UniqueMaskOfText(String index, String firstHundredCharacters, int lengthOfFileInOneString, String nameOfFile) {
            this.index = index;
            this.firstHundredCharacters = firstHundredCharacters;
            this.lengthOfFileInOneString = lengthOfFileInOneString;
            this.nameOfFile = nameOfFile;
        }

    }
}
