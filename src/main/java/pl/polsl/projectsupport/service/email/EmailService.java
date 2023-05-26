package pl.polsl.projectsupport.service.email;

import pl.polsl.projectsupport.dto.AttendanceDto;
import pl.polsl.projectsupport.dto.StudentTeamDto;

public interface EmailService {
    void sendTestMessage(String to, String subject, String text);

    void sendNewGradeNotification(String to, StudentTeamDto dto);

    void sendNewTeamNotification(String to, StudentTeamDto dto);

    void sendNewAttendanceNotification(String to, AttendanceDto dto, String firstName, String topic);
}
