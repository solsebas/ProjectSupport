import {Student} from "./student";
import {Team} from "./team";
import {Attendance} from "./attendance";

export class TeamMember {
  id: bigint
  student: Student
  grade: number
  team: Team
  attendanceList: Attendance[]

  constructor(id: bigint, student: Student, grade: number, team: Team, attendanceList: Attendance[]) {
    this.id = id;
    this.student = student;
    this.grade = grade;
    this.team = team;
    this.attendanceList = attendanceList;
  }
}
