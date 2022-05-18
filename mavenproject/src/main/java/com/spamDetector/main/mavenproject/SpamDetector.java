package com.spamDetector.main.mavenproject;

import java.util.regex.Pattern;


public class SpamDetector {

	private final String spamWords;
	private final double spamThreshold;
	
	
	public SpamDetector( final String spamWords, final double spamThreshold) {
		/**
		 * 
		 */
		super();
		this.spamWords = spamWords;
		this.spamThreshold = spamThreshold;
	}
	/**
	 * 
	 * @param spamWords String of coma separated words that are considered spam
	 * @param spamThreshold double value that represents the ratio of spam words to non spam words
	 * @return a new SpamDetector object
	 */
	public static SpamDetector of(final String spamWords, final double spamThreshold) {
		final String spamWordsLowerCase = spamWords.toLowerCase();
		return new SpamDetector(spamWordsLowerCase, spamThreshold);
	}
	
	/**
	 * 
	 * @param text the String to be checked for spam
	 * @return true if the ratio is greater or equal to the threshold, false otherwise
	 */
	public Boolean check(final String text) {
		final String textLowerCase = text.toLowerCase();
		final String spamPattern = this.spamWords.replaceAll(",", "|");
		final Pattern pattern = Pattern.compile(spamPattern);
		final String[] wordArray = textLowerCase.split("\\s+");
		final String[] spamlessArray = pattern.split(textLowerCase);
		final int k = spamlessArray.length - 1;
		final double l = wordArray.length;
		final double ratio = k/l;
		return ratio>=this.spamThreshold;
	}
	
}
