package pp.text;

import pp.processingTexts.Indexes;

/**
 * Created by Admin on 3/31/2017.
 */
public class TextMask {
    String index;
    String nameOfFile;
    String firstHundredCharacters;
    Integer lengthOfFileInOneString;
    boolean newCurrentTextMask;

    public TextMask(String index, String firstHundredCharacters, int lengthOfFileInOneString, String nameOfFile, boolean newMask) {
        this.index = index;
        this.nameOfFile = nameOfFile;
        this.firstHundredCharacters = firstHundredCharacters;
        this.lengthOfFileInOneString = lengthOfFileInOneString;
        this.newCurrentTextMask = newMask;
    }

    public TextMask(String firstHundredCharacters, int lengthOfFileInOneString, String nameOfFile, boolean newMask) {
        this.index = new Indexes().defineRandomUniqueIndex16_02();
        this.nameOfFile = nameOfFile;
        this.firstHundredCharacters = firstHundredCharacters;
        this.lengthOfFileInOneString = lengthOfFileInOneString;
        this.newCurrentTextMask = newMask;
    }

    public TextMask() {
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public void setFirstHundredCharacters(String firstHundredCharacters) {
        this.firstHundredCharacters = firstHundredCharacters;
    }

    public void setLengthOfFileInOneString(int lengthOfFileInOneString) {
        this.lengthOfFileInOneString = lengthOfFileInOneString;
    }

    public void setNewCurrentTextMask(boolean newCurrentTextMask) {
        this.newCurrentTextMask = newCurrentTextMask;
    }

    public String getIndex() {
        return index;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public String getFirstHundredCharacters() {
        return firstHundredCharacters;
    }

    public Integer getLengthOfFileInOneString() {
        return lengthOfFileInOneString;
    }

    public boolean isNewCurrentTextMask() {
        return newCurrentTextMask;
    }

    @Override
    public String toString() {
        return "TextMask{" +
                "index='" + index + '\'' +
                ", nameOfFile='" + nameOfFile + '\'' +
                ", firstHundredCharacters='" + firstHundredCharacters + '\'' +
                ", lengthOfFileInOneString=" + lengthOfFileInOneString +
                ", newCurrentTextMask=" + newCurrentTextMask +
                '}';
    }
}
