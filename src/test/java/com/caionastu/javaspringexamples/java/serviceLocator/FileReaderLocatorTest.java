package com.caionastu.javaspringexamples.java.serviceLocator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderLocatorTest {

    @BeforeEach
    void resetInstances() {
        FileReaderContext.getInstance()
                .resetContext();

        FileReaderLocator.getInstance()
                .clearCache();
    }

    @Test
    @DisplayName("Get a Json FileReader that is loaded in initial context.")
    void getJsonReader() {
        IFileReader reader = FileReaderLocator.getInstance()
                .getReader(ContentType.JSON);

        assertEquals(ContentType.JSON.getReaderName(), reader.getName());
    }

    @Test
    @DisplayName("Get a CSV FileReader that is loaded in initial context.")
    void getCsvReader() {
        IFileReader reader = FileReaderLocator.getInstance()
                .getReader(ContentType.CSV);

        assertEquals(ContentType.CSV.getReaderName(), reader.getName());
    }

    @Test
    @DisplayName("Get a FileReader that is not in initial context.")
    void GetReaderNotInInitialContext() {
        assertThrows(FileReaderNotFoundException.class, () -> {
            FileReaderLocator.getInstance()
                    .getReader(ContentType.TEXT);
        });
    }

    @Test
    @DisplayName("Register and retrieve new FileReader from runtime.")
    void registerNewFileReader() {
        IFileReader newFileReader = new TextReader();

        FileReaderContext.getInstance()
                .register(newFileReader);

        IFileReader fileReader = FileReaderLocator.getInstance()
                .getReader(ContentType.TEXT);

        assertEquals(ContentType.TEXT.getReaderName(), fileReader.getName());
    }

    @Test
    @DisplayName("Register a existent FileReader.")
    void registerExistentFileReader() {
        IFileReader existentFileReader = new JsonReader();

        assertThrows(FileReaderAlreadyExistInContextException.class, () -> {
            FileReaderContext.getInstance()
                    .register(existentFileReader);
        });
    }

    @Test
    @DisplayName("Register a new FileReader that has the same name of a existent file reader.")
    void registerNewFileReaderWithSameName() {
        IFileReader newFileReader = new IFileReader() {
            @Override
            public void read(String file) {
                System.out.println("New File reader reading a file: " + file);
            }

            @Override
            public String getName() {
                return ContentType.JSON.getReaderName();
            }
        };

        assertThrows(FileReaderAlreadyExistInContextException.class, () -> {
            FileReaderContext.getInstance()
                    .register(newFileReader);
        });
    }


}
