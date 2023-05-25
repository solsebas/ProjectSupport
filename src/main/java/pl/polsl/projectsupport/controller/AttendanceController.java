package pl.polsl.projectsupport.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projectsupport.dto.AttendanceDto;
import pl.polsl.projectsupport.service.AttendanceService;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERVISOR')")
    public void addAttendance(@RequestBody AttendanceDto dto){
        attendanceService.addAttendance(dto);
    }
}
