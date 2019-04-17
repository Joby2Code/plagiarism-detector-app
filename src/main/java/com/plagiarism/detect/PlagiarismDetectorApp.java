package com.plagiarism.detect;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.plagiarism.detect.cli.MainCLIParameters;
import com.plagiarism.detect.constants.Constants;
import com.plagiarism.detect.service.PlagiarismDetectorService;

public class PlagiarismDetectorApp {

	final MainCLIParameters mainArgs = new MainCLIParameters();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlagiarismDetectorApp app = new PlagiarismDetectorApp();

		System.out.println();

		app.handleInputArgs(args);
		app.run();

		app.detectPlagiarism();

		app.exit();

	}

	void exit() {
		System.out.println("Exiting application....");
		System.exit(0);

	}

	void detectPlagiarism() {
		PlagiarismDetectorService service = new PlagiarismDetectorService();
		service.parseSysArgs(mainArgs);
		service.detectPlagiarism(Constants.isSameFileSizeFlag);
	}

	void handleInputArgs(String args[]) {
		
		/*
		 * Parse command line arguments using JCommander
		 */
		
		JCommander jCommander = new JCommander(mainArgs);
		jCommander.setProgramName("pgdetector");

		try {
			jCommander.parse(args);
		} catch (ParameterException exception) {
			System.out.println(exception.getMessage());
			showUsage(jCommander);
		}

		if (mainArgs.isHelp()) {
			showUsage(jCommander);
		}
	}

	void showUsage(JCommander jCommander) {
		/*
		 * show help options to the user
		 */
		jCommander.usage();
		System.exit(0);
	}

	void run() {
		System.out.println("Running plagirism detector with configuration...");
		System.out.println(mainArgs.toString());
		System.out.println();
	}

}
