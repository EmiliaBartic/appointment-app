package com.project.dtos;

import com.project.models.Appointment;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DoctorDto {
    private Long id;
    private String name;
    private String schedule;
    private List<Appointment> appointments;
}
