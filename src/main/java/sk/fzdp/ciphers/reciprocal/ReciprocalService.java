package sk.fzdp.ciphers.reciprocal;

import org.springframework.stereotype.Repository;

@Repository
public class ReciprocalService {
	
	public String encode(String text) {
		char[] chars = text.toCharArray();
		
		for(int i = 0; i < chars.length; i ++) {
			char c = chars[i];
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					chars[i] = (char) ('Z' - (c - 'A'));
				} else {
					chars[i] = (char) ('z' - (c - 'a'));
				}
			}
		}
		return new String(chars);
	}
	
	public String decode(String text) {
		char[] chars = text.toCharArray();
		
		for(int i = 0; i < chars.length; i ++) {
			char c = chars[i];
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					chars[i] = (char) ('Z' - (c - 'A'));
				} else {
					chars[i] = (char) ('z' - (c - 'a'));
				}
			}
		}
		return new String(chars);
	}
}
