package com.plagiarism.detect.service;

import com.plagiarism.detect.cli.MainCLIParameters;
import com.plagiarism.detect.model.DiffData;
import com.plagiarism.detect.util.CommonUtils;

public class PlagiarismDetectorService {

	public DiffData diffData;

	public PlagiarismDetectorService() {
		diffData = new DiffData();
	}

	public void parseSysArgs(MainCLIParameters mainArgs) {

		// Create a map of all the synonym pairs from the synonym file
		diffData.setSynonyms(CommonUtils.generateSynonymDict(mainArgs.getFileSynonym()));

		// Parse the input text files
		diffData.setFileFirst(CommonUtils.parseFile(mainArgs.getFileFirst()));
		diffData.setFileSecond(CommonUtils.parseFile(mainArgs.getFileSecond()));

		// Parse the N tuple size
		diffData.setTupleSize(mainArgs.getSize());

	}

	public void detectPlagiarism(boolean detectOnSameFileSize) {

		int minLen = Math.min(diffData.getFileFirst().length, diffData.getFileSecond().length);
		if (diffData.getTupleSize() > minLen) {
			System.out.println("N tuple size is greater than the file size...");
			return;
		}

		/*
		 * Assuming that the plagiarism check should happens if and only if the two
		 * files that are of the same size
		 */

		if (detectOnSameFileSize && diffData.getFileFirst().length != diffData.getFileSecond().length) {
			System.out.println("Mismatch in input file size observed, cannot proceed with plagiarism detection");
			return;
		}

		// invoking NTuple algorithm
		NTupleAlgorithm alg = new NTupleAlgorithm(diffData.getTupleSize());
		double percentDetected = alg.compareFiles(diffData.getFileFirst(), diffData.getFileSecond());

		System.out.println();

		System.out.println("**************************************");
		String message = String.format("Plagiarism observed to be at: %.3f percent", percentDetected);
		System.out.println(message);
		System.out.println("**************************************");

		System.out.println();
	}

}
