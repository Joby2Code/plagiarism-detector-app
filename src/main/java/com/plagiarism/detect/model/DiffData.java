package com.plagiarism.detect.model;

public class DiffData {

	private String[] synonyms = null;
	private String[] fileFirst;
	private String[] fileSecond;
	private int tupleSize;

	public DiffData() {
	}

	public String[] getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String[] synonyms) {
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
