package com.sumel.jobsearch.cli;

import com.beust.jcommander.JCommander;

import java.util.function.Supplier;

public class CommanderFunctions {
    public static <T> JCommander buidCommanderWithName(String cliName, Supplier <T> argumentsSupplier){

        JCommander jCommander = JCommander.newBuilder()
                .addCommand(argumentsSupplier.get())
                .build();
        jCommander.setProgramName(cliName);
        return jCommander;
    }
}
