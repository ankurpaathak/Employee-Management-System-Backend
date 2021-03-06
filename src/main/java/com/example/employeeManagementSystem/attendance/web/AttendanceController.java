package com.example.employeeManagementSystem.attendance.web;

import com.example.employeeManagementSystem.attendance.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.List;


@RestController
@RequestMapping(path = "/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping(value = "/mark")
    public String attendance(@RequestBody AttendanceRequestDto attendanceRequestDto){
        return attendanceService.markAttendance(attendanceRequestDto);
    }

    @PutMapping(value = "/update")
    public String attendanceUpdate(@RequestBody AttendanceUpdateRequestDto attendanceUpdateRequestDto){
        return attendanceService.updateAttendance(attendanceUpdateRequestDto);
    }

    @GetMapping(value = "/{id}")
    public AttendanceResponseDto getAttendanceById(@PathVariable Integer id){
        return attendanceService.getAttendanceByAttendanceId(id);
    }

    @GetMapping(value = "/employee")
    public List<AttendanceResponseDto> getAttendanceByMonth(Integer empId, @NotNull Month month, @NotNull Integer year){
        return attendanceService.getAttendanceByMonth(empId,month,year);
    }

}



