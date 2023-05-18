package databean;

public enum Services {
    SWAPI_SERVICE("swapi/swapi", "swapi/swapi"),
    SECURIAN("securian/securian","securian/securian");


    private String inputFile, outputFile;

    Services(String ipFile, String opFile) {
        this.inputFile = ipFile;
        this.outputFile = opFile;
    }

    public String getIpFile() {
        return this.inputFile;
    }

    public String getopFile() {
        return this.outputFile;
    }
}
