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

  constructor(limit: number) {
    this.limit = limit;
  }
}
