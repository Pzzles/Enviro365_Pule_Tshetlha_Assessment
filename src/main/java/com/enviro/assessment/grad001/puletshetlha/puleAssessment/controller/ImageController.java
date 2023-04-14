package com.enviro.assessment.grad001.puletshetlha.puleAssessment.controller;


import com.enviro.assessment.grad001.puletshetlha.puleAssessment.model.AccountProfile;
import com.enviro.assessment.grad001.puletshetlha.puleAssessment.service.AccountProfileService;
import com.enviro.assessment.grad001.puletshetlha.puleAssessment.service.Base64ImageToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


@RestController
@RequestMapping("/v1/api/image")
public class ImageController {

    private final AccountProfileService accountProfileService;

    @Autowired
    private Base64ImageToFile base64ImageToFile;
    private final JdbcTemplate jdbcTemplate;

    public ImageController(AccountProfileService accountProfileService, Base64ImageToFile base64ImageToFile, JdbcTemplate jdbcTemplate) {
        this.accountProfileService = accountProfileService;
        this.base64ImageToFile = base64ImageToFile;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/{name}/{surname}/{fileName:.+}")
    public ResponseEntity<FileSystemResource> gethttpImageLink(@PathVariable String name, @PathVariable String surname, @PathVariable String fileName) throws IOException {
        String sql = "SELECT httpimagelink FROM ACCOUNTPROFILE WHERE name = ? AND surname = ?";
        String httpImageLink = jdbcTemplate.queryForObject(sql, String.class, name, surname);

        String fileDirectory = "C:\\Users\\PULE\\Desktop\\Documents\\enviro";
        FileSystemResource imageResource = new FileSystemResource(fileDirectory + fileName);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(imageResource.contentLength())
                .contentType(MediaType.parseMediaType("image/jpeg"))
                .body(imageResource);
    }



    @GetMapping("/read")
    public void readcsvfile(){
        File cvsfile = new File("C:\\Users\\PULE\\Desktop\\Documents\\enviro\\1672815113084-GraduateDev_AssessmentCsv_Ref003.csv");
        base64ImageToFile.parseCSV(cvsfile);

    }
}

