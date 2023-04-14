package com.enviro.assessment.grad001.puletshetlha.puleAssessment.service;

import com.enviro.assessment.grad001.puletshetlha.puleAssessment.FileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Base64ImageToFile implements FileParser {
@Autowired
    private AccountProfileService accountProfileService;
    private final String directory;

    public Base64ImageToFile(@Value("${image.directory}") String directory) {
        //this.accountProfileService = accountProfileService;
        this.directory = directory;
    }

    @Override
    public void parseCSV(File csvFile) {
        if(csvFile != null){
        try {
            List<String> lines = Files.readAllLines(csvFile.toPath());
            lines.remove(0); // remove header line
            int count = 0;
            for (String line : lines) {
                count++;
                String[] fields = line.split(",");
                String name = fields[0];
                String surname = fields[1];
                String format = fields[2];
                String imageData = fields[3];
                File imageFile = convertCSVDataToImage(imageData);
                URI imageLink = createImageLink(imageFile);

                System.out.println("Image link created: " + imageLink);
                accountProfileService.save(name, surname, imageLink.toString());

            }
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }
        }else{
            System.out.println("NO CSV!!!");
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64ImageData);
        File imageFile = null;
        try {
            String filename = "\\image" + System.currentTimeMillis() + ".jpeg";
            File file = new File(directory + filename);
            imageFile = file.getCanonicalFile();
            try (FileOutputStream outputStream = new FileOutputStream(imageFile)) {
                outputStream.write(decodedBytes);
            }
        } catch (IOException e) {
        }
        return imageFile;
    }

    @Override
    public URI createImageLink(File fileImage) {
        String myServer = "http://192.168.0.40:8080/";
        String imagePath = fileImage.getPath().replace("\\", "/");
        String httpImageLink = myServer + imagePath;

        try {
            return new URI(httpImageLink);
        } catch (URISyntaxException ex) {
            System.out.println("URI syntax exception: " + ex.getMessage());
            return null;
        }
    }
}
