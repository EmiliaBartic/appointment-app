package com.project.models;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class DoctorSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Many appointments can be associated with one doctor
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    private LocalTime monday_start;
    private LocalTime monday_end;
    private LocalTime tuesday_start;
    private LocalTime tuesday_end;
    private LocalTime wednesday_start;
    private LocalTime wednesday_end;
    private LocalTime thursday_start;
    private LocalTime thursday_end;
    private LocalTime friday_start;
    private LocalTime friday_end;
    private LocalTime saturday_start;
    private LocalTime saturday_end;
    private LocalTime sunday_start;
    private LocalTime sunday_end;
}
