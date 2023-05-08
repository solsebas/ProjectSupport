export class Topic {
  id?: bigint
  topicName: string;
  topicDescription: string;


  constructor(topicName: string, topicDescription: string) {
    this.topicName = topicName;
    this.topicDescription = topicDescription;
  }

}
