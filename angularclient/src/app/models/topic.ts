export class Topic {
  id?: bigint
  topicName: string;
  topicDescription: string;
  archieve: boolean ;
  idUser?: BigInt;

  constructor(topicName: string, topicDescription: string, archieve:boolean ) {
    this.topicName = topicName;
    this.topicDescription = topicDescription;
    this.archieve = archieve;
  }
}
