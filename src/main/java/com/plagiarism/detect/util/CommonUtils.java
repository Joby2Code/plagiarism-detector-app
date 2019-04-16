package com.plagiarism.detect.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

	public static String[] parseFile(Path path, boolean isFileSynonym) {
		System.out.println("reading file " + path.getFileName());
		List<String> contents = new ArrayList<>();
		try {

			Files.lines(path).map(s -> s.trim()).filter(s -> !s.isEmpty())
					.forEach(s -> addFileData(s, isFileSynonym, contents));
		} catch (Exception e) {

		}
		return  contents.toArray(new String[0]);

	}

	public static void addFileData(String s, boolean isFileSyn, List<String> content) {
		if (!isFileSyn) {
			String[] arr = s.split(" ");
			for (String str : arr) {
				content.add(str);
			}
		} else {
			content.add(s);
		}
	}

}
