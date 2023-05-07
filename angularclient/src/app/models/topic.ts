export class Topic {
  id?: bigint
  topicName: string;
  topicDescription: string;

  idUser?: BigInt;

  constructor(topicName: string, topicDescription: string) {
    this.topicName = topicName;
    this.topicDescription = topicDescription;
  }

}
