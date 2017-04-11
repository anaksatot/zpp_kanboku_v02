package pp.textFileProcessing;

import com.google.common.io.Files;
import pp.text.TextMask;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class TextFileImproveServiceImpl implements TextFileImproveService {

	public boolean fileExist(String pathToFile) {
		if (!new File(pathToFile).isFile()) {
			System.out.println("File not found " + pathToFile);
		}
		return new File(pathToFile).isFile();
	}

	public boolean fileIsTXT(String pathToFile) {
		return Files.getFileExtension(pathToFile).equals("txt");
	}

	public  boolean fileIsJSON(String pathToFile) {
		return Files.getFileExtension(pathToFile).equals("json");
	}

	@Override
	public TextMask uniqueMaskOfTXTfile(String textInOneString, String pathToFile) {

		String firstHundredCharacters;
		if (textInOneString.length()>100) {
			firstHundredCharacters = textInOneString.substring(0,99);
		} else {
			firstHundredCharacters = textInOneString.substring(0,textInOneString.length()-1);
		}
		Set<TextMask> setOfTextsAlreadyProcessed = new XMLfileReadAndWriteServiceImpl().readFromXMLsetAlreadyProcessedFiles();
		for (TextMask tm:setOfTextsAlreadyProcessed) {
			if (tm.getLengthOfFileInOneString()==textInOneString.length()&&tm.getFirstHundredCharacters().equals(firstHundredCharacters)) {
				return tm;
			}
		}
		return new TextMask(firstHundredCharacters, textInOneString.length(),new File(pathToFile).getName(), true);
	}



}
