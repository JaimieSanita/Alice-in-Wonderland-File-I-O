package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {

		File inputFile = getInputFileFromUser();
		String wordSearch = getWordSearch();
		String wordReplacement = getReplacement();
		String destination = getReplacementDestination();

		try (Scanner fileScanner = new Scanner(inputFile)) {

			while (fileScanner.hasNextLine()) {

				String line = fileScanner.nextLine();
				fileContents.add(line);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		replaceWord(wordSearch, wordReplacement);
		writeFile(destination);
	}

	private static void writeFile(String destination) {

		File newFile = new File(destination);

		try (PrintWriter writer = new PrintWriter(newFile)) {

			for (int i = 0; i < fileContents.size(); i++) {
				writer.println(fileContents.get(i));
				if (!newFile.isFile()) {
					System.out.println("We need a file. This is not a file.");
					System.exit(1);
				}

			}
		} catch (FileNotFoundException e) {
			System.exit(1);
			e.printStackTrace();
		}

	}

	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in); // scanner
		System.out.println("What is the file that should be searched?");
		String path = userInput.nextLine(); // will read next line of user as a string

		File inputFile = new File(path); // construct file object using path provided from user

		if (!inputFile.exists()) {
			System.out.println(path + " does not exist.");
			System.exit(1);
		} else if (!inputFile.isFile()) {
			System.out.println(path + " is not a file.");
			System.exit(1);
		} else if (!inputFile.canRead()) {
			System.out.println(path + " can not be read.");
			System.exit(1);
		}
		return inputFile;
	}

	private static String getWordSearch() {
		Scanner userString = new Scanner(System.in);
		System.out.println("What is the search word you are looking for?");
		String wordSearch = userString.nextLine();
		return wordSearch;
	}

	private static String getReplacement() {
		Scanner userString = new Scanner(System.in);
		System.out.println("What is the word you'd like to replace search word with?");
		String wordReplacement = userString.nextLine();
		return wordReplacement;

	}

	public static List<String> fileContents = new ArrayList<String>();

	public static void replaceWord(String wordSearch, String wordReplacement) {
		String temp;
		for (int i = 0; i < fileContents.size(); i++) {
			temp = fileContents.get(i).replaceAll(wordSearch, wordReplacement);
			fileContents.set(i, temp);

		}
	}

	private static String getReplacementDestination() {
		Scanner userString = new Scanner(System.in);
		System.out.println("Where would you like this to be saved?");
		String destination = userString.nextLine();
		return destination;

	}

}
