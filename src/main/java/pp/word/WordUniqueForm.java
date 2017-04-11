package pp.word;

import pp.linguisticCategories.Language;
import pp.linguisticCategories.LinguisticCategoryForms;
import pp.processingTexts.Indexes;
import pp.stringProcessing.XIvCharsetProcessing;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

@Entity
@Table (name= "word_unique_form")
public class WordUniqueForm implements Serializable {
	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name= "word")
	private String formOfWord;
	@Transient private String formOfWordFirstLetterCapital;
	@Transient private String formOfWordInLowerCase;
	@Transient private String formOfWordInCapitalCase;
	@Transient private String formOfWordStrangeCaseOrder;
	@Column(name= "quantity_symbols")
	private Integer quantityOfSymbols;
	@Column(name= "formOfWordXIVsystem")
	private String formOfWordXIVsystem;
	private String uniqueIndex;
	@Transient private Language language;
	@Transient private LinguisticCategoryForms linguisticCategoryForms;
	private static Integer accountOfWords;
	private Integer accountWordsOfThisUniqueForm;

	static {
		accountOfWords = XMLfileReadAndWriteServiceImpl.readFromXMLStatisticInformation().get("totalAccountOfWords");
	}
	public WordUniqueForm(String formOfWord,Language language) {

		this.formOfWord = formOfWord.toLowerCase();
		this.language = language;
		this.quantityOfSymbols = formOfWord.length();
		this.uniqueIndex = new Indexes().defineRandomUniqueIndex16_01(accountOfWords);
		this.accountWordsOfThisUniqueForm = 1;
		checkAndWriteFormsWithCapitalAndLowerLetters(formOfWord);
		this.formOfWordXIVsystem =  new XIvCharsetProcessing().firstXIvSystemOrthographyOfWord(formOfWord, language);
		++accountOfWords;

	}

	public WordUniqueForm() {
	}

	public int getId() {
		return id;
	}

	public String getFormOfWord() {
		return formOfWord;
	}

	public int getQuantitySymbols() {
		return quantityOfSymbols;
	}

	public String getUniqueIndex() {
		return uniqueIndex;
	}

	public Language getLanguage() {
		return language;
	}

	public Integer getAccountWordsOfThisUniqueForm() {
		return accountWordsOfThisUniqueForm;
	}

	public String getFormOfWordXIVsystem() {
		return formOfWordXIVsystem;
	}

	public void setLinguisticCategoryForms(LinguisticCategoryForms linguisticCategoryForms) {
		this.linguisticCategoryForms = linguisticCategoryForms;
	}

	public static Integer getAccountOfWords() {
		return accountOfWords;
	}

	public LinguisticCategoryForms getLinguisticCategoryForms() {
		return linguisticCategoryForms;
	}

	@Override
	public String toString() {
		return "WordUniqueForm{" +
				"formOfWord='" + formOfWord + '\'' +
				", formOfWordFirstLetterCapital='" + formOfWordFirstLetterCapital + '\'' +
				", formOfWordInLowerCase='" + formOfWordInLowerCase + '\'' +
				", formOfWordInUpperCase='" + formOfWordInCapitalCase + '\'' +
				", formOfWordStrangeCaseOrder='" + formOfWordStrangeCaseOrder + '\'' +
				", quantityOfSymbols=" + quantityOfSymbols +
				", uniqueIndex=" + uniqueIndex +
				", language=" + language +
				", linguisticCategoryForms=" + linguisticCategoryForms +
				'}';
	}

	public void setFormOfWordFirstLetterCapital(String word) {
		this.formOfWordFirstLetterCapital= word;

	}

	public void setFormOfWordInLowerCase(String word) {
		this.formOfWordInLowerCase = word;
	}

	public void setFormOfWordInCapitalCase(String word) {
		this.formOfWordInCapitalCase = word;
	}

	public void setFormOfWordStrangeCaseOrder(String word) {
		this.formOfWordStrangeCaseOrder = word;
	}

	public void setAccountWordsOfThisUniqueForm(Integer accountWordsOfThisUniqueForm) {
		this.accountWordsOfThisUniqueForm = accountWordsOfThisUniqueForm;
	}

	public boolean isEmptyFormOfWordFirstLetterCapital() {
		return this.formOfWordFirstLetterCapital == null || this.formOfWordFirstLetterCapital.isEmpty();
	}

	public boolean isEmptyFormOfWordInLowerCase() {
		return this.formOfWordInLowerCase == null || this.formOfWordInLowerCase.isEmpty();
	}

	public boolean isEmptyFormOfWordInCapitalCase() {
		return this.formOfWordInCapitalCase == null || this.formOfWordInCapitalCase.isEmpty();
	}

	public boolean isEmptyFormOfWordStrangeCaseOrder() {
		return this.formOfWordStrangeCaseOrder == null || this.formOfWordStrangeCaseOrder.isEmpty();
	}

	public boolean checkAndWriteFormsWithCapitalAndLowerLetters(String word) {

		if (this.isEmptyFormOfWordFirstLetterCapital() && (word.substring(0,1).matches("[А-Я\\u0406\\u0407\\u0490\\u0404]")&&word.substring(1).matches("[а-я-\\u0456\\u0457\\u0491\\u0454]+"))) {
			this.setFormOfWordFirstLetterCapital(word);
			return true;
		}
		if (this.isEmptyFormOfWordInLowerCase() && (word.matches("[а-я-\\u0456\\u0457\\u0491\\u0454]+"))) {
			this.setFormOfWordInLowerCase(word);
			return true;
		}

		if (this.isEmptyFormOfWordInCapitalCase() && (word.matches("[А-Я\\u0406\\u0407\\u0490\\u0404]+"))) {
			this.setFormOfWordInCapitalCase(word);
			return true;
		}
		if (this.isEmptyFormOfWordStrangeCaseOrder() && (word.matches("[А-Я\\u0406\\u0407\\u0490\\u0404а-я-\\u0456\\u0457\\u0491\\u0454]+"))) {
			this.setFormOfWordStrangeCaseOrder(word);
			return true;
		}
		return false;
	}
}
