package pp.textFileProcessing;


import pp.text.TextMask;

public interface TextFileImproveService {
	boolean fileExist(String pathToFile);
	boolean fileIsTXT(String pathToFile);
	boolean fileIsJSON(String pathToFile);
	TextMask uniqueMaskOfTXTfile(String textInOneString, String pathToFile);
}
