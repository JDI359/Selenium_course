package com.selenium.course.utils;

import com.opencsv.exceptions.CsvException;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReader {

    public static Object[][] readCsvFile(String filename) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(filename))) {
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObject = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++){
                csvDataObject[i] = csvData.get(i);
            }
            return csvDataObject;
        }
    }
}
