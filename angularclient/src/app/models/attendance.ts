export class Attendance {
  id: bigint;
  present: boolean;
  date: string;

  constructor(id: bigint, present: boolean, date: string) {
    this.id = id;
    this.present = present;
    this.date = date;
  }
}
