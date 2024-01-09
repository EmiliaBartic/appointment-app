package com.project.controllers;

import com.project.models.Doctor;
import com.project.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors/add")
    public String showAddDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "add-doctor";
    }

    @GetMapping("/doctors/all")
    public String findAllDoctors(Model model) {
        List<Doctor> doctors = doctorService.findAllDoctorsModifiedSchedule();
        model.addAttribute("doctors", doctors);
        return "doctors";
    }

    @PostMapping("/doctors/add")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        doctorService.addDoctorToDb(doctor);
        return "doctors";
    }

    @DeleteMapping("/doctor/id")
    public String deleteDoctorById(Long id) {
        doctorService.deleteDoctorById(id);
        return "doctors";
    }


}
