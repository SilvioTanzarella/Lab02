package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translations;
	
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translations = new LinkedList<String>();
		this.addTranslation(translation);
	}


	public String getAlienWord() {
		return alienWord;
	}


	public List<String> getTranslations() {
		return translations;
	}
	
	public void addTranslation(String s) {
		for(String t: this.translations)
		{
			if(t.equals(s))
				return;
		}
		this.translations.add(s);
	}
	
	
	
	
	
	

}
