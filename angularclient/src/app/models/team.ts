import {Topic} from "./topic";
import {Student} from "./student";
import {Term} from "./term";

export class Team {

  id?: bigint

  limit: number

  status?: string

  topic?: Topic

  term?: Term

  studentList?: Student[]

  constructor(limit: number, term?: Term, topic?: Topic) {
    this.limit = limit;
    this.term = term;
    this.topic = topic;
  }
}
