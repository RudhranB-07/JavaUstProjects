package com.java.mailcsv.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class CSVReaderService {
    public List<String> readEmailsFromCSV(MultipartFile file) throws IOException {
        List<String> emails = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] nextLine;
            try {
				while ((nextLine = reader.readNext()) != null) {
				    if (nextLine.length > 0) {  // Ensure non-empty lines
				        emails.add(nextLine[0]); // Read first column as email
				    }
				}
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return emails;
    }
}
