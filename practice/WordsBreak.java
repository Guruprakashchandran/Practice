package com.practice;

public class WordsBreak {

	public static void main(String[] args) {
		
		new WordsBreak().setContents();
	}

	private void setContents() {

//		String[] words = {"i","like","sam","sung","samsung","mobile","not"};
		String[] words = 
			
			
			
			{ "i", "like", "sam", "sung", "samsung", "mobile", "ice", "and", "cream", "icecream", "man", "go", "mango"};
//		String sentence = "ilikesamsungmobile";
		String sentence = "ilikeicecreamandmango";
	//					   01				
		System.out.println("outputs : ");
		sentenceForming(words,sentence,0,"");
	}

	private void sentenceForming(String[] words, String sentence, int i, String senForm) {

		if(i == sentence.length()) {
			
			System.out.println(senForm);
			return;
		}
		for(int j = 0;j<words.length;++j) {
			
	//			System.out.println(words[j] + " "+ sentence.substring(i,i+words[j].length()));//go gone length = 2 size = 4
			if(i + words[j].length() <= sentence.length()&& words[j].equals(sentence.substring(i,i+words[j].length()))) {
				
				senForm += words[j]+" ";
				i += words[j].length();
				sentenceForming(words,sentence,i,senForm);
				i -= words[j].length();
				senForm = senForm.substring(0,senForm.length()-words[j].length()-1);
//				System.out.println("sentence "+senForm);
//				System.out.println("length : "+senForm.length());
//				System.out.println("i : "+i);
			}
		}
		return;
	}
}
