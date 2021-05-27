package com.company.controller;

import com.company.actions.UserActions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
    @GetMapping("/upload")
    public String Upload() {
        return "upload";
    }

    @PostMapping("/upload")
    public String Upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            UserActions.addUserFromFile(file);
            return "goodupload";
        }
        return "empty";
    }
}
