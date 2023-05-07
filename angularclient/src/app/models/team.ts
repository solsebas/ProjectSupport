import {Topic} from "./topic";
import {Student} from "./student";

export class Team {

  id: bigint

  limit: bigint

  status: string

  topic: Topic

  term: bigint

  studentList: Student[]

  constructor(id: bigint, limit: bigint, status: string, topic: Topic, term: bigint, student: Student[]) {
    this.id = id;
    this.limit = limit;
    this.status = status;
    this.topic = topic;
    this.term = term;
    this.studentList = student;
  }
}
