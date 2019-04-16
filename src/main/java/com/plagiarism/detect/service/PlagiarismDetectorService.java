package com.plagiarism.detect.service;

import com.plagiarism.detect.cli.MainCLIParameters;
import com.plagiarism.detect.model.DiffData;
import com.plagiarism.detect.util.CommonUtils;

public class PlagiarismDetectorService {

	private static PlagiarismDetectorService _instance = null;

	public DiffData diffData;

	public PlagiarismDetectorService() {
		diffData = new DiffData();
	}

	public void parseSysArgs(MainCLIParameters mainArgs) {
		diffData.setTupleSize(mainArgs.getSize());

		diffData.setFileFirst(CommonUtils.parseFile(mainArgs.getFileFirst(), false));

		diffData.setFileSecond(CommonUtils.parseFile(mainArgs.getFileSecond(), false));

		diffData.setSynonyms(CommonUtils.parseFile(mainArgs.getFileSecond(), true));

		diffData.setTupleSize(mainArgs.getSize());

	}

}
