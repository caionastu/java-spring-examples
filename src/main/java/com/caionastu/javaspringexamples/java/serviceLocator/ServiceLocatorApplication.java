package com.caionastu.javaspringexamples.java.serviceLocator;

class ServiceLocatorApplication {
    public static void main(String[] args) {
        String fileContent = "This is a file that tells the universe's secrets.";

        FileReaderLocator fileReaderLocator = FileReaderLocator.getInstance();
        IFileReader reader = fileReaderLocator
                .getReader(ContentType.JSON);

        reader.read(fileContent);

        addTextFileReader();

        IFileReader textReader = fileReaderLocator.getReader(ContentType.TEXT);
        textReader.read(fileContent);

        fileReaderLocator.logCachedReaders();

        IFileReader csvReader = fileReaderLocator.getReader(ContentType.CSV);
        csvReader.read(fileContent);

        fileReaderLocator.logCachedReaders();

        fileReaderLocator.clearCache();
        fileReaderLocator.logCachedReaders();
    }

    private static void addTextFileReader() {
        IFileReader textFileReader = new TextReader();
        FileReaderContext.getInstance()
                .register(textFileReader);

    }


}
