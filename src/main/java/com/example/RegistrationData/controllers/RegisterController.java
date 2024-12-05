package com.example.RegistrationData.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.RegistrationData.model.InputData;
import com.example.RegistrationData.repositories.InputDataRepository;



@Controller
public class RegisterController {
    @Autowired
    private InputDataRepository myFormDataService;


     // Show the form page
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("myFormData", new InputData());
        return "form";
    }



    // Handle form submission
    @PostMapping("/submit")
    public String submitForm(@ModelAttribute InputData formData,
                             @RequestParam("image") MultipartFile file) {
                                
                                // return "redirect:/add";
        try {
            myFormDataService.test();
            myFormDataService.saveData(formData,file);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/add"; // Redirect to list after saving
    }

    // Display all submitted data
    @GetMapping("/list")
    public String listData(Model model) {
        model.addAttribute("myFormDataList", myFormDataService.getAllData());
        return "list"; // Display data on this page
    }



}
