package com.plagiarism.detect.service;

import java.util.LinkedList;

public class NTupleAlgorithm {
	private int tupleSize;
	private LinkedList<String> dequeOne;
	private LinkedList<String> dequeTwo;

	public NTupleAlgorithm(int _size) {
		this.tupleSize = _size;
		dequeOne = new LinkedList<>();
		dequeTwo = new LinkedList<>();
	}

	public double compareFiles(String[] fileone, String[] filetwo) {
		/*
		 * compare two files and check for percentage of words that mean the same. 
		 * dequeOne and dequeTwo are two linkedlist that keep elements in the given window size
		 */
		System.out.println("Plagiarism Detection in Progress");
		
		int windowSize = tupleSize;
		double matches = 0; //Total matches found
		double total_tuples_found = 0; //Total groups
		int len = Math.max(fileone.length, filetwo.length); //Max length of the two files
		
		for (int i = 0; i < len; i++) {
			
			if (dequeOne.size() < windowSize && dequeTwo.size() < windowSize) {
				String first = i >= fileone.length ? "" : fileone[i];
				String second = i >= filetwo.length ? "" : filetwo[i];
				dequeOne.addLast(first);
				dequeTwo.addLast(second);
				continue;
			}

			total_tuples_found++;
			int temp = compareWindowWords();
			if (temp == dequeOne.size()) {
				matches++;
			}
			dequeOne.pollFirst(); //pop out the word to keep the window size equal to the tuple size
			dequeTwo.pollFirst();
			i--;
		}

		if (!dequeOne.isEmpty() && !dequeTwo.isEmpty()) { //Look for the last tuple
			total_tuples_found++;
			int temp = compareWindowWords();
			if (temp == dequeOne.size()) {
				matches++;
			}
			removeDequeElements();
		}
		total_tuples_found = total_tuples_found == 0 ? 1 : total_tuples_found;
		double percent_plag = matches / total_tuples_found * 100;
		return percent_plag;
	}

	public int compareWindowWords() {
		int index = 0;
		int size = dequeOne.size();
		int temp = 0;

		while (index < size) {
			if (!dequeOne.get(index).equals(dequeTwo.get(index))) //if words in the quueu doesn't match break
				break;
			temp++;
			index++;
		}
		return temp;
	}

	public void removeDequeElements() {
		dequeOne = null;
		dequeTwo = null;
	}

}
