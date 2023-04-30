export class Topic {
  topicName: string;
  topicDescription: string;
  idUser: number;

  constructor(topicName: string, topicDescription: string, idUser: number) {
    this.topicName = topicName;
    this.topicDescription = topicDescription;
    this.idUser = idUser;
  }

}
