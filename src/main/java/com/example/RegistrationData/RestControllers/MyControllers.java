package com.example.RegistrationData.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.GetExchange;

import com.example.RegistrationData.model.InputData;
import com.example.RegistrationData.repositories.InputDataRepository;

//,@RequestParam("image") MultipartFile file

@RestController
// @RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Frontend origin
public class MyControllers {
    @Autowired
    private InputDataRepository myFormDataService;

    private InputData formData = new InputData();

    //Handle the list to return from the database
    @GetMapping("/api/list")

    public ResponseEntity<List<InputData>> showList(){
        return new ResponseEntity<>(myFormDataService.getAllData(), HttpStatus.OK);
    }



    // Handle form submission
    @PostMapping("/api/submit")
    
    public ResponseEntity<List<InputData>> submitForm(@RequestParam("name") String name,
    @RequestParam("description") String description,@RequestParam("image") MultipartFile file) {
                                
                                // return "redirect:/add";
        try {
           System.out.println(name);
           System.out.println(description);
           formData.setName(name);
           formData.setDescription(description);
           myFormDataService.saveData(formData, file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    

        return new ResponseEntity<>(myFormDataService.getAllData(), HttpStatus.OK);
        // return "redirect:/add"; // Redirect to list after saving
    }

}
