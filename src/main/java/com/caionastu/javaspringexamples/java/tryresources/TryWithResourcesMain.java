package com.caionastu.javaspringexamples.java.tryresources;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
class TryWithResourcesMain {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("pathToFile"))) {
            log.info("File read.");
        } catch (FileNotFoundException ex) {
            log.info("File not found.");
        } catch (IOException exception) {
            log.info("Error while reading file.");
        }
    }
}
