package com.sumel.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {
    CLIArguments(){

    }
    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            validateWith = CLIKeyWordValidator.class,
            description = "Keyword")
    private String keyWord;
    @Parameter(
            names = {"--location", "-l"},
            description = "Somewhere location"
            )
    private  String location;
    @Parameter(
            names = {"--page", "-p"},
            description = "API 50 answers, one number for page"
    )
    private int page = 0;
    @Parameter(
            names = {"--full-time"},
            description = "If search jobs full-time"
    )
    private boolean isFullTime = false;
    @Parameter(
            names = "--markdown",
            description = "Get search in markdown"
    )
    private boolean isMarkdown = false;
    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Show help"
    )
    private boolean isHelp;

    public String getKeyWord() {
        return keyWord;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyWord='" + keyWord + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    /**
     * Funcion encarda de si se necesita modificar
     * la manera en que se crean los argumento del terminal cambie
     * asi no se dependen del constructor
     * */
    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
}
