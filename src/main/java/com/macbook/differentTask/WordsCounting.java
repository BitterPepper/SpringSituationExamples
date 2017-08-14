package com.macbook.differentTask;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsCounting {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String sentence = "фыва. пролджэ. фыва. пролджэ. йцукен: sdgdfgdg. sdfbdfb: гшщзхъ: ячсмить бю.";
		System.out.println("Enter a sentence to search for entries:");
		String sentence = scanner.nextLine();
		int count = 0;
//		Pattern p = Pattern.compile("\\.[^\\.]+\\:", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
//		Pattern p = Pattern.compile("([^.]+)(?=:[^:]*$", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
		Pattern p = Pattern.compile("\\b[a-z]{3,}\\b", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(sentence);
		while (m.find()) {
			count++;
			System.out.printf("Match found №%d: %s%n",count, m.group(0));
		}
		System.out.println("Total matches found: "+count);
		scanner.close();
	}
}
