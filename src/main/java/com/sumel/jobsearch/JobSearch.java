package com.sumel.jobsearch;

import com.beust.jcommander.JCommander;
import com.sumel.jobsearch.api.APIJobs;
import com.sumel.jobsearch.cli.CLIArguments;
import com.sumel.jobsearch.cli.CLIFunctions;
import com.sumel.jobsearch.model.JobPosition;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.sumel.jobsearch.api.APIFuntions.buildAPI;
import static com.sumel.jobsearch.cli.CommanderFunctions.*;

public class JobSearch {
    public static void main(String[] args) {
        System.out.println("---Hello say Job Search---");
        JCommander jCommander = buidCommanderWithName("job-search", CLIArguments::newInstance);
        /*Se obtinen en Streams los argumentos que se dieron por erminal*/
        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj->(CLIArguments)obj);

        /*Se obtiene los argumentos que no sean ayuda y los que sean Keywords*/
        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli->!cli.isHelp())
                .filter(cli->cli.getKeyWord() != null)
                .findFirst();

        /*Convertir el Optional para la URL y se ejecuta la peticion*/
        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static  Stream<JobPosition> executeRequest(Map<String,Object> params){
        APIJobs api = buildAPI(APIJobs.class, "htpps://jobs.github.com");

        return  Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
