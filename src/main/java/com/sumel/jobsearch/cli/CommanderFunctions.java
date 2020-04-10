package com.sumel.jobsearch.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {
    public static <T> JCommander buidCommanderWithName(String cliName, Supplier <T> argumentsSupplier){

        JCommander jCommander = JCommander.newBuilder()
                .addObject(argumentsSupplier.get())
                .build();
        jCommander.setProgramName(cliName);
        return jCommander;
    }

    /**Funcion que ayuda a transformar argumentos
     * En caso de Execption se mostrara la ayuda dada supplier
     * */
    public static Optional<List<Object>> parseArguments(JCommander jCommander, String[] args, Consumer<JCommander> onError){

        try {
            jCommander.parse(args);
            return  Optional.of(jCommander.getObjects());
        }catch (ParameterException e){
            e.printStackTrace();
            onError.accept(jCommander);
        }
        return Optional.empty();
    }
}
