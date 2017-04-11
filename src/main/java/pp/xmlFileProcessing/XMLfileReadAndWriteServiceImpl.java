package pp.xmlFileProcessing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import pp.linguisticCategories.*;
import pp.linguisticCategories.linguisticCategoriesService.LinguisticCategoriesServiceImpl;
import pp.text.TextMask;
import pp.word.WordUniqueForm;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class XMLfileReadAndWriteServiceImpl implements XMLfileReadAndWriteService {

    public static boolean saveToXMLStatisticInformationCompleted() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("Statistic");
            doc.appendChild(rootElement);
            Element node = doc.createElement("totalAccountOfWords");
            node.appendChild(doc.createTextNode(WordUniqueForm.getAccountOfWords().toString()));
            rootElement.appendChild(node);
            Element nodeAdjective = doc.createElement("totalAccountOfWordsAdjective");
            nodeAdjective.appendChild(doc.createTextNode(LcAdjectiveUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeAdjective);
            Element nodeAdverb = doc.createElement("totalAccountOfWordsAdverb");
            nodeAdverb.appendChild(doc.createTextNode(LcAdverbUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeAdverb);
            Element nodeConjunction = doc.createElement("totalAccountOfWordsConjunction");
            nodeConjunction.appendChild(doc.createTextNode(LcConjunctionUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeConjunction);
            Element nodeNoun = doc.createElement("totalAccountOfWordsNoun");
            nodeNoun.appendChild(doc.createTextNode(LcNounUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeNoun);
            Element nodeNumeral = doc.createElement("totalAccountOfWordsNumeral");
            nodeNumeral.appendChild(doc.createTextNode(LcNumeralUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeNumeral);
            Element nodePreposition = doc.createElement("totalAccountOfWordsPreposition");
            nodePreposition.appendChild(doc.createTextNode(LcPrepositionUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodePreposition);
            Element nodePronoun = doc.createElement("totalAccountOfWordsPronoun");
            nodePronoun.appendChild(doc.createTextNode(LcPronounUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodePronoun);
            Element nodeVerb = doc.createElement("totalAccountOfWordsVerb");
            nodeVerb.appendChild(doc.createTextNode(LcVerbUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeVerb);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            Path path_emps = Paths.get(new File("").getAbsolutePath()+"\\veslid\\words unique form\\statistic.xml");
            StreamResult file = new StreamResult(new File(path_emps.toString()));
            transformer.transform(source, file);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    return false;
    }

    public static void saveToXMLStartStatisticInformation() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("Statistic");
            doc.appendChild(rootElement);
            Element node = doc.createElement("totalAccountOfWords");
            node.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(node);
            Element nodeAdjective = doc.createElement("totalAccountOfWordsAdjective");
            nodeAdjective.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeAdjective);
            Element nodeAdverb = doc.createElement("totalAccountOfWordsAdverb");
            nodeAdverb.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeAdverb);
            Element nodeConjunction = doc.createElement("totalAccountOfWordsConjunction");
            nodeConjunction.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeConjunction);
            Element nodeNoun = doc.createElement("totalAccountOfWordsNoun");
            nodeNoun.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeNoun);
            Element nodeNumeral = doc.createElement("totalAccountOfWordsNumeral");
            nodeNumeral.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeNumeral);
            Element nodePreposition = doc.createElement("totalAccountOfWordsPreposition");
            nodePreposition.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodePreposition);
            Element nodePronoun = doc.createElement("totalAccountOfWordsPronoun");
            nodePronoun.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodePronoun);
            Element nodeVerb = doc.createElement("totalAccountOfWordsVerb");
            nodeVerb.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeVerb);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            Path path_emps = Paths.get(new File("").getAbsolutePath()+"\\veslid\\words unique form\\statistic.xml");
            StreamResult file = new StreamResult(new File(path_emps.toString()));
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void saveToXMLStartNodeListAlreadyProcessedFiles() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("listOfUniqueTexts");
            doc.appendChild(rootElement);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            Path path_emps = Paths.get(new File("").getAbsolutePath()+"\\veslid\\texts\\listAlreadyProcessedFiles.xml");
            StreamResult file = new StreamResult(new File(path_emps.toString()));
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveToXMLnewTextMaskCurrent(TextMask textMask) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("").getAbsolutePath()+"\\veslid\\texts\\listAlreadyProcessedFiles.xml");
            Element rootElement = doc.getDocumentElement();
            Element textElement = doc.createElement("text");
            Element index = doc.createElement("index");
            index.setTextContent(textMask.getIndex());
            Element nameOfFile = doc.createElement("nameOfFile");
            nameOfFile.setTextContent(textMask.getNameOfFile());
            Element firstHundredCharacters = doc.createElement("firstHundredCharacters");
            firstHundredCharacters.setTextContent(textMask.getFirstHundredCharacters());
            Element lengthOfFileInOneString = doc.createElement("lengthOfFileInOneString");
            lengthOfFileInOneString.setTextContent(textMask.getLengthOfFileInOneString().toString());
            textElement.appendChild(index);
            textElement.appendChild(nameOfFile);
            textElement.appendChild(firstHundredCharacters);
            textElement.appendChild(lengthOfFileInOneString);
            rootElement.appendChild(textElement);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            Path path_emps = Paths.get(new File("").getAbsolutePath()+"\\veslid\\texts\\listAlreadyProcessedFiles.xml");
            StreamResult file = new StreamResult(new File(path_emps.toString()));
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String,Integer> readFromXMLStatisticInformation() {
        Map<String,Integer> accountOfWords = LinguisticCategoriesServiceImpl.listOfStatisticItem();
        try {
            Path path_emps = Paths.get(new File("").getAbsolutePath()+"\\veslid\\words unique form\\statistic.xml");
            File fXmlFile = new File(path_emps.toString());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            for (Map.Entry<String,Integer> accountTypeEntry: accountOfWords.entrySet()) {
                Element elementXML = (Element) doc.getElementsByTagName(accountTypeEntry.getKey()).item(0);
                accountTypeEntry.setValue(Integer.valueOf(elementXML.getTextContent()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountOfWords;
    }


    public static Set<TextMask> readFromXMLsetAlreadyProcessedFiles() {
        Set<TextMask> textsMasks = new HashSet<TextMask>();
        try {
            Path path_xml = Paths.get(new File("").getAbsolutePath()+"\\veslid\\texts\\listAlreadyProcessedFiles.xml");
            File fXmlFile = new File(path_xml.toString());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("text");
            for (int i = 0; i < nodeList.getLength(); i++) {
                textsMasks.add(getTextMask(nodeList.item(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textsMasks;
    }

    private static TextMask getTextMask(Node node) {
        TextMask tm = new TextMask();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            tm.setIndex(getTagValue("index", element));
            tm.setNameOfFile(getTagValue("nameOfFile", element));
            tm.setFirstHundredCharacters(getTagValue("firstHundredCharacters", element));
            tm.setLengthOfFileInOneString(Integer.parseInt(getTagValue("lengthOfFileInOneString", element)));
            tm.setNewCurrentTextMask(false);
        }
        return tm;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public  static void defineSystemParameters() {

        if (systemParametersIsNotCompleted()) {
            writeDefaultSystemParameters();
        }
    }

    public static Boolean systemParametersIsNotCompleted() {
        Path path = Paths.get(new File("").getAbsolutePath()+"\\veslid\\");
        Path path_words_unique_form = Paths.get(path+"\\words unique form\\");
        Path path_json = Paths.get(path_words_unique_form+"\\db json files\\");
        Path path_stats = Paths.get(path_words_unique_form+"\\statistic.xml");
        Path path_texts = Paths.get(path+"\\texts\\");
        Path path_db_txt_files = Paths.get(path_texts+"\\db txt files\\");
        Path path_list_texts = Paths.get(path_texts+"\\listAlreadyProcessedFiles.xml");
        if (!Files.exists(path)||!Files.exists(path_words_unique_form)||!Files.exists(path_json)
                ||!Files.exists(path_stats)||!Files.exists(path_texts)||!Files.exists(path_db_txt_files)||!Files.exists(path_list_texts)) {
            return true;
        }
        return false;
    }


    public static void writeDefaultSystemParameters() {

        Path path = Paths.get(new File("").getAbsolutePath()+"\\veslid\\");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Path path_words_unique_form = Paths.get(path+"\\words unique form\\");
        if (!Files.exists(path_words_unique_form)) {
            try {
                Files.createDirectories(path_words_unique_form);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Path path_json = Paths.get(path_words_unique_form+"\\db json files\\");
        if (!Files.exists(path_json)) {
            try {
                Files.createDirectories(path_json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Path path_statistic = Paths.get(path_words_unique_form+"\\statistic.xml");
        if (!Files.exists(path_statistic)) {
            try {
                Files.createFile(path_statistic);
                saveToXMLStartStatisticInformation();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Path path_texts = Paths.get(path+"\\texts\\");
        if (!Files.exists(path_texts)) {
            try {
                Files.createDirectories(path_texts);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Path path_db_txt_files = Paths.get(path_texts+"\\db txt files\\");
        if (!Files.exists(path_db_txt_files)) {
            try {
                Files.createDirectories(path_db_txt_files);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Path path_listAlreadyProcessedFiles = Paths.get(path_texts+"\\listAlreadyProcessedFiles.xml");
        if (!Files.exists(path_listAlreadyProcessedFiles)) {
            try {
                Files.createFile(path_listAlreadyProcessedFiles);
                saveToXMLStartNodeListAlreadyProcessedFiles();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
