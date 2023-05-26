import {TeamMember} from "./team-member";

export class Attendance {
  id?: bigint;
  present: boolean;
  date: string;
  memberId: bigint;

  constructor(present: boolean, date: string, member: bigint) {
    this.present = present;
    this.date = date;
    this.memberId = member;
  }
}
