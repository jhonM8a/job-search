package com.sumel.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIKeyWordValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches("^[a-zA-Z]+[0-9]*$")){
            System.err.println("Keyword invalid in search");
            throw  new ParameterException("Only number an letters");
        }
    }
}
