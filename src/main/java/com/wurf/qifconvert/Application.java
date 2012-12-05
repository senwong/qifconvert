package com.wurf.qifconvert;

import com.wurf.qifconvert.builder.QifBuilder;
import com.wurf.qifconvert.dto.Csv;
import com.wurf.qifconvert.dto.hibiscus1.Hibiscus1;
import com.wurf.qifconvert.dto.qif.QifDto;
import com.wurf.qifconvert.util.ResourceParseUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.CharEncoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.print("Path to a *.qif file: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File inputFile = null;
        try {
            inputFile = new File(br.readLine());
            if(!inputFile.exists()) {
                exit("File not found: " + inputFile.getAbsolutePath());
            }
        } catch (IOException ioe) {
            exit("IO error trying to read your name!");
        }
        QifDto qif = QifBuilder.getQifDto(ResourceParseUtil.parseResource(inputFile.toURI().toURL()));
        List<Csv<Hibiscus1>> csvs = new QifMapper<Hibiscus1>().toCsv(qif, Hibiscus1.class);

        for (Csv<Hibiscus1> csv : csvs) {
            File output = getOutputFile(inputFile, csv);
            System.out.println("Writing to " + output.getAbsolutePath());
            FileUtils.writeStringToFile(output, csv.toString(), CharEncoding.UTF_8);
        }
    }

    protected static File getOutputFile(File inputFile, Csv<Hibiscus1> csv) {
        String baseName = FilenameUtils.getBaseName(inputFile.getName());
        String accountName = csv.getAccountName().toLowerCase().replace(' ', '_');
        String filename = String.format("%s.%s.csv", baseName, accountName);
        return new File(inputFile.getParent(), filename);
    }

    private static void exit(String message) {
        System.out.println(message);
        System.exit(1);
    }
}
