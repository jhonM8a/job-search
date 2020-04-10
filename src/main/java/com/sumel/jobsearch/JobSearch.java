package com.sumel.jobsearch;

import com.beust.jcommander.JCommander;
import com.sumel.jobsearch.cli.CLIArguments;
import static com.sumel.jobsearch.cli.CommanderFunctions.buidCommanderWithName;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("---Hello say Job Search---");
        JCommander jCommander = buidCommanderWithName("job-search", CLIArguments::newInstance);
    }
}
