import {Student} from "./student";
import {Team} from "./team";
import {Attendance} from "./attendance";

export class TeamMember {
  student: Student
  grade: number
  team: Team
  attendanceList: Attendance[]

  constructor(student: Student, grade: number, team: Team, attendance: Attendance[]) {
    this.student = student
    this.grade = grade
    this.team = team
    this.attendanceList = attendance
  }
}
