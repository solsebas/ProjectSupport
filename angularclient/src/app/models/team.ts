import {Topic} from "./topic";
import {Student} from "./student";

export class Team {

  id?: bigint

  limit: number

  status?: string

  topic?: Topic

  term?: bigint

  studentList?: Student[]

  constructor(limit: number) {
    this.limit = limit;
  }
}
