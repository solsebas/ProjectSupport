package pl.polsl.projectsupport.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.polsl.projectsupport.dto.AttendanceDto;
import pl.polsl.projectsupport.dto.StudentTeamDto;

import java.util.Objects;

@Component
public class EmailServiceImpl implements EmailService {

    private static final String NEW_GRADE_SUBJECT = "Wystawiono nową ocenę!";
    private static final String NEW_TEAM_SUBJECT = "Dodano Cię do nowego zespołu!";
    private static final String NEW_ATTENDANCE_SUBJECT = "Wystawiono obecność!";
    private static final String MAIL_FOOTER = "Mail pełni funkcję informacyjną, proszę na niego nie odpowiadać.";
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendTestMessage(String to, String subject, String text) {
        if (Objects.equals(to, "")) return;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ProjectSupport");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendNewGradeNotification(String to, StudentTeamDto dto) {
        if (Objects.equals(to, "")) return;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ProjectSupport");
        message.setTo(to);
        message.setSubject(NEW_GRADE_SUBJECT);
        message.setText("Cześć " + dto.getStudent().getFirstName() + ",\n" +
                "Twoja ocena przy projekcie " + dto.getTeam().getTopic().getTopicName() + " została zaktualizowana. " +
                "Wpisana ocena to: " + dto.getGrade() + "\n\n" +
                MAIL_FOOTER);
        emailSender.send(message);
    }

    @Override
    public void sendNewTeamNotification(String to, StudentTeamDto dto) {
        if (Objects.equals(to, "")) return;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ProjectSupport");
        message.setTo(to);
        message.setSubject(NEW_TEAM_SUBJECT);
        message.setText("Cześć " + dto.getStudent().getFirstName() + ",\n" +
                "Zostałeś/łaś dodany do pracy przy projekcie:\n" +
                teamDetailsMessage(dto) + "\n\n" +
                MAIL_FOOTER);
        emailSender.send(message);
    }

    @Override
    public void sendNewAttendanceNotification(String to, AttendanceDto dto, String firstName, String topic) {
        if (Objects.equals(to, "")) return;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ProjectSupport");
        message.setTo(to);
        message.setSubject(NEW_ATTENDANCE_SUBJECT);
        message.setText("Cześć " + firstName + ",\n" +
                "Została wpisana Ci obecność przy projekcie " + topic + ". " +
                "Dnia " + dto.getDate() + " byłeś/łaś " + (!dto.isPresent() ? "nie " : "") + "obecny/a\n\n" +
                MAIL_FOOTER);
        emailSender.send(message);
    }

    private String teamDetailsMessage(StudentTeamDto dto) {
        String details = "Temat: " + dto.getTeam().getTopic().getTopicName() +
                "\nOpis: " + dto.getTeam().getTopic().getTopicDescription() +
                "\nCzłonkowie zespołu:";
        for (var member : dto.getTeam().getStudentList()){
            details += "\n\t " + member.getFirstName() + " " + member.getSurname();
        }
        return details;
    }
}
