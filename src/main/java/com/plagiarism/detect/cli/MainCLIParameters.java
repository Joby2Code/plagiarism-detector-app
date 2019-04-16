package com.plagiarism.detect.cli;

import java.nio.file.Path;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.plagiarism.detect.constants.Constants;

@Parameters(separators = "=")
public class MainCLIParameters {

	@Parameter(names = { "-h", "--help" }, help = true, description = "Displays help information")
	private boolean help;

	@Parameter(names = { "-s",
			"--synonym" }, required = true, validateWith = FileParameterValidator.class, converter = PathConverter.class, description = "Absolute path to file containing all the synonyms.")
	private Path fileSynonym;

	@Parameter(names = { "-f1",
			"--file1" }, required = true, validateWith = FileParameterValidator.class, converter = PathConverter.class, description = "Absolute path to first file.")
	private Path fileFirst;

	@Parameter(names = { "-f2",
			"--file2" }, required = true, validateWith = FileParameterValidator.class, converter = PathConverter.class, description = "Absolute path to second file.")
	private Path fileSecond;

	@Parameter(names = { "-N", "--size" }, validateWith = TupleValidator.class, description = "The size of the tuple")
	private Integer tuple_size = Constants.TUPLE_SIZE; // default set to 3

	public boolean isHelp() {
		return help;
	}

	public Path getFileSynonym() {
		return fileSynonym;
	}

	public Path getFileFirst() {
		return fileFirst;
	}

	public Path getFileSecond() {
		return fileSecond;
	}

	public Integer getSize() {
		return tuple_size;
	}

	public String toString() {
		return "\nhelp=" + help + "\nsynonymFile=" + fileSynonym + "\nfileFirst=" + fileFirst + "\nfileSecond="
				+ fileSecond + "\ntuple size=" + tuple_size;
	}
}
