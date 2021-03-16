package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	List<WordEnhanced> parole;

	public AlienDictionary() {
		parole = new LinkedList<WordEnhanced>();
	}
	
	public void addWord(String alienWord,  String translation) {
		for(WordEnhanced w: parole) {
			if(alienWord.toLowerCase().equals(w.getAlienWord().toLowerCase())) {
				w.addTranslation(translation);
				return;
			}
		}
		parole.add(new WordEnhanced(alienWord, translation));
	}
	
	
	public String translateWord(String alienWord) {
		for(WordEnhanced w:parole) {
			if(alienWord.toLowerCase().equals(w.getAlienWord().toLowerCase()))
			{
				String s = "";
				for(String t: w.getTranslations())
				{
					s += t+"\n";
				}
				return s;
			}
		}
		return null;
	}
	
	
	public String compareString(String s) {
		if(!s.contains("?"))
			return null;
		String aw = "";
		int interrogativo = s.indexOf('?');
		
		for(int i=0;i<parole.size();i++)
		{
			int dif = 0;
			int pos=0;
			aw = parole.get(i).getAlienWord();
			if(aw.length() == s.length())
			{
				for(int j=0; j<aw.length();j++)
				{
					if(aw.charAt(j) != s.charAt(j))
					{
						dif++;
						if(dif==1)
							pos = j;
					}
				}
				if((dif == 1)&&(pos == interrogativo))
					return aw;
			}
				
		}
		return null;
	}
}
