package com.plagiarism.detect.model;

import java.util.HashMap;
import java.util.Map;

public class DiffData {
	
	/*
	 * model object to store all the user input data
	 */

	private Map<String, String> synonyms;
	private String[] fileFirst;
	private String[] fileSecond;
	private int tupleSize;

	public DiffData() {
		synonyms = new HashMap<>();
	}

	public Map<String, String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(Map<String, String> synonyms) {
		this.synonyms = synonyms;
	}

	public String[] getFileFirst() {
		return fileFirst;
	}

	public void setFileFirst(String[] fileFirst) {
		this.fileFirst = fileFirst;
	}

	public String[] getFileSecond() {
		return fileSecond;
	}

	public void setFileSecond(String[] fileSecond) {
		this.fileSecond = fileSecond;
	}

	public int getTupleSize() {
		return tupleSize;
	}

	public void setTupleSize(int tupleSize) {
		this.tupleSize = tupleSize;
	}

}
