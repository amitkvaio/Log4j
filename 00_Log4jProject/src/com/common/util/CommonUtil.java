package com.common.util;

public class CommonUtil {
	//USED FOR CHECKING DIGIT IN A WORD
	public static  boolean checkNotHavingDigitInWord(String word){
		boolean status = false;
		for (int i = 0; i < word.length(); i++) {
			if ((Character.isDigit(word.charAt(i)))){
				status = true;
				break;
			}
		}
		if(status)
			System.out.println("GIVEN WORD HAVING DIGIT!");
		else
			System.out.println("GIVEN WORD NOT HAVING DIGIT");
		return status;
	}
	
	public static void main(String[] args) {
		boolean status =checkNotHavingDigitInWord("sdf");
		System.out.println("status=>"+status);
	}
}
