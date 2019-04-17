package com.plagiarism.detect.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class TupleValidator implements IParameterValidator {

	public void validate(String name, String value) throws ParameterException {
		
		try {
			int val = Integer.parseInt(value);
			if (val < 1) {
				String message = String.format("Tuple size [%s] cannot be less than 1: ", value);
				throw new ParameterException(message);
			}
		} catch (Exception e) {
			String message = String.format("Tuple Size: [%s] [%s] is not a valid: ",name,value);
			throw new ParameterException(message);
		}

	}

}
