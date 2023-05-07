export class Student {
  id: bigint
  firstName: string
  surname: string

  constructor(id: bigint, firstName: string, surname: string) {
    this.id = id
    this.firstName = firstName
    this.surname = surname
  }
}
