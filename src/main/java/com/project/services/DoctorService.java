package com.project.services;

import com.project.models.Doctor;
import com.project.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void addDoctorToDb(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(new Doctor());
    }


    public List<Doctor> findAllDoctorsModifiedSchedule() {
        List<Doctor> doctors = doctorRepository.findAll();
        for (Doctor d: doctors) {
            d.setSchedule(modifySchedule(d.getScheduleMap()));
        }
        return doctors;
    }

    private String modifySchedule(Map<String, Map<String, String>> schedule) {
        StringBuilder s = new StringBuilder();
        Integer startHour = 0;
        Integer endHour =  0;
        if (schedule.get("monday") != null) {
            startHour = Integer.valueOf(schedule.get("monday").get("start"));
            endHour =  Integer.valueOf(schedule.get("monday").get("end"));

            if (startHour == 0 && endHour == 0)
                s.append("MONDAY - NO PROGRAM");
            else
                s.append("MONDAY " + startHour + "-" + endHour + "\n");
        }

        if (schedule.get("tuesday") != null) {
            startHour = Integer.valueOf(schedule.get("tuesday").get("start"));
            endHour =  Integer.valueOf(schedule.get("tuesday").get("end"));

            if (startHour == 0 && endHour == 0)
                s.append("TUESDAY - NO PROGRAM");
            else
                s.append("TUESDAY " + startHour + "-" + endHour + "\n");
        }

        if (schedule.get("wednesday") != null) {
            startHour = Integer.valueOf(schedule.get("wednesday").get("start"));
            endHour =  Integer.valueOf(schedule.get("wednesday").get("end"));

            if (startHour == 0 && endHour == 0)
                s.append("WEDNESDAY - NO PROGRAM");
            else
                s.append("WEDNESDAY " + startHour + "-" + endHour + "\n");
        }

        if (schedule.get("thursday") != null) {
            startHour = Integer.valueOf(schedule.get("thursday").get("start"));
            endHour =  Integer.valueOf(schedule.get("thursday").get("end"));

            if (startHour == 0 && endHour == 0)
                s.append("THURSDAY - NO PROGRAM");
            else
                s.append("THURSDAY " + startHour + "-" + endHour + "\n");
        }

        if (schedule.get("friday") != null) {
            startHour = Integer.valueOf(schedule.get("friday").get("start"));
            endHour =  Integer.valueOf(schedule.get("friday").get("end"));

            if (startHour == 0 && endHour == 0)
                s.append("FRIDAY - NO PROGRAM");
            else
                s.append("FRIDAY " + startHour + "-" + endHour + "\n");
        }

        if (schedule.get("saturday") != null) {
            startHour = Integer.valueOf(schedule.get("saturday").get("start"));
            endHour =  Integer.valueOf(schedule.get("saturday").get("end"));

            if (startHour == 0 && endHour == 0)
                s.append("SATURDAY - NO PROGRAM");
            else
                s.append("SATURDAY " + startHour + "-" + endHour + "\n");
        }

        if (schedule.get("sunday") != null) {
            startHour = Integer.valueOf(schedule.get("sunday").get("start"));
            endHour =  Integer.valueOf(schedule.get("sunday").get("end"));

            if (startHour == 0 && endHour == 0)
                s.append("SUNDAY - NO PROGRAM");
            else
                s.append("SUNDAY " + startHour + "-" + endHour + "\n");
        }
        return s.toString();
    }
}
