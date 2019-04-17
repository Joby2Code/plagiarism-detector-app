package com.plagiarism.detect.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtils {

	static Map<String, String> synonymMap = null;

	public static String[] parseFile(Path path) {
		/*
		 * read a file and convert to array of words
		 */
		System.out.println("reading file " + path.getFileName());

		if (synonymMap.size() == 0) {
			System.out.println("Please upload the synonyms file to check for plagiarism.");
			return null;
		}

		List<String> contents = new ArrayList<>();

		try {

			Files.lines(path).map(s -> s.trim()).filter(s -> !s.isEmpty())
					.forEach(s -> addFileData(s.split(" "), contents));
		} catch (Exception e) {
			String messgae = "Unable to process input files";
			System.out.println(messgae);
		}
		return contents.toArray(new String[0]);

	}

	public static Map<String, String> generateSynonymDict(Path path) {
		/*
		 * read the synonym file and generate the synonym dict for each word within the dict
		 */
		System.out.println("generating the synonym key value mapping for file " + path.getFileName());
		synonymMap = new HashMap<>();

		try {
			Files.lines(path).map(s -> s.trim()).filter(s -> !s.isEmpty()).forEach(s -> createSynonymPairs(s));
		} catch (Exception e) {
			String messgae = "Unable to process synonym files";
			System.out.println(messgae);
		}

		return synonymMap;

	}

	public static void createSynonymPairs(String s) {
		String[] str_array = s.split(" ");
		for (String str : str_array) {
			synonymMap.put(str, s);
		}
	}

	public static void addFileData(String[] arr, List<String> content) {
		for (String str : arr) {
			if (synonymMap.containsKey(str)) {
				String[] vals = synonymMap.get(str).split(" "); //check in the synonym dictionary and replace the value in the main file
				for (String v : vals) {
					content.add(v);
				}

			} else {
				content.add(str);
			}
		}

	}

}
