export class Term {
  id: BigInt;
  major: string;
  termNumber: number;

  constructor(id: BigInt, major: string, termNumber: number) {
    this.id = id;
    this.major = major;
    this.termNumber = termNumber;
  }
}
