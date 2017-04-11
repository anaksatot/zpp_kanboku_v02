package pp.textFileProcessing;

import jdk.nashorn.internal.objects.NativeArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pp.word.WordUniqueForm;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class TextFileReadAndWriteServiceImpl implements TextFileReadAndWriteService {

    public String read(String pathToFile) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader inBR = new BufferedReader(new FileReader(new File(pathToFile)));
            //BufferedReader inBR = new BufferedReader(new InputStreamReader(new FileInputStream(PathToFile), "UTF-8" ));
            String s;
            while ((s = inBR.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            System.out.println("file not readable");
            return "";
        }
        return sb.toString();
    }

    public void writeToJSONfile(String stForJSONParser, String formOfWord) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject WordUniqueFormJSONObj = (JSONObject) parser.parse(stForJSONParser);
        try {
            File file=new File(directoryForSaveJSONfilesWordUniqueForm()+"\\"+formOfWord.toLowerCase()+".json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(WordUniqueFormJSONObj.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void writeNewTextIntoFilesDB(String pathToFile, String indexOfText, Map<WordUniqueForm,Integer> mapWordsOfCurrentText) throws IOException, ParseException {

        String directoryForSavingNewText = directoryForSaveJSONfilesWordUniqueFormNewText();
        Path path_oldText = Paths.get(pathToFile);
        Path path_newDirectory = Paths.get(directoryForSavingNewText+"\\"+indexOfText+"\\");
        if (!Files.exists(path_newDirectory)) {
            try {
                Files.createDirectories(path_newDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path path_newText = Paths.get(path_newDirectory+"\\"+indexOfText+".txt");
        Files.copy(path_oldText,path_newText);
        SaveWordUniqueFormIntoJsonFiles(path_newDirectory+"\\",mapWordsOfCurrentText);
    }

    private void SaveWordUniqueFormIntoJsonFiles(String directoryForSavingWordsNewTextIntoJsonFiles, Map<WordUniqueForm,Integer> mapWordsOfCurrentText) throws ParseException {
        System.out.println(directoryForSavingWordsNewTextIntoJsonFiles);
        for (Map.Entry<WordUniqueForm,Integer> mapWords:mapWordsOfCurrentText.entrySet()) {
            writeToJSONfilesNewText(new JsonFileReadAndWriteServiceImpl().stringForJSONParserWordUniqueForm(mapWords.getKey()), mapWords.getKey().getFormOfWord(), directoryForSavingWordsNewTextIntoJsonFiles);
        }
    }

    public void writeToJSONfilesNewText(String stForJSONParser, String formOfWord,String directoryForSavingWordsNewTextIntoJsonFiles) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject WordUniqueFormJSONObj = (JSONObject) parser.parse(stForJSONParser);
        try {
            File file=new File(directoryForSavingWordsNewTextIntoJsonFiles+"\\"+formOfWord.toLowerCase()+".json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(WordUniqueFormJSONObj.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void writeToJSONfilesStatistic(Map<WordUniqueForm,Integer> listWordsOfCurrentText){
        for (Map.Entry<WordUniqueForm,Integer>wordOfCurrentText: listWordsOfCurrentText.entrySet()) {
            wordOfCurrentText.getKey().setAccountWordsOfThisUniqueForm(wordOfCurrentText.getValue()+wordOfCurrentText.getKey().getAccountWordsOfThisUniqueForm());
            try {
                new TextFileReadAndWriteServiceImpl().writeToJSONfile(new JsonFileReadAndWriteServiceImpl().stringForJSONParserWordUniqueForm(wordOfCurrentText.getKey()), wordOfCurrentText.getKey().getFormOfWord());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static String directoryForSaveJSONfilesWordUniqueForm(){
        Path path_json_files = Paths.get(new File("").getAbsolutePath()+"\\veslid\\words unique form\\db json files\\");
        return path_json_files.toString()+"\\";
    }


    public static String directoryForSaveJSONfilesWordUniqueFormNewText(){
        Path path_json_files = Paths.get(new File("").getAbsolutePath()+"\\veslid\\texts\\db txt files\\");
        return path_json_files.toString()+"\\";
    }

    public String pathToTXTFile(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input file for processing");
        String st = scanner.nextLine();
        return st;

    }

    public static void serializeWordUniqueForm(WordUniqueForm wordUniqueForm) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("e:\\Develop\\ser-jamu\\" + wordUniqueForm.getFormOfWord() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wordUniqueForm);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void deserializeWordUniqueForm(String fileName) {
        WordUniqueForm wordUniqueForm =null ;
        try
        {
            FileInputStream fis = new FileInputStream("e:\\Develop\\ser-jamu\\"+fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wordUniqueForm = (WordUniqueForm)ois.readObject();
            ois.close();
            fis.close();
        }
        catch(ClassNotFoundException nfe)
        {
            nfe.printStackTrace();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
        catch (Exception e)
        { e.printStackTrace(); }
    }

}
