package com.enviro.assessment.grad001.puletshetlha.puleAssessment;

import java.io.File;
import java.net.URI;


public interface FileParser{

    public void parseCSV(File csvFile);
    public File convertCSVDataToImage(String base64ImageData) ;
    public URI createImageLink(File filelmage) ;
}