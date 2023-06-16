export class Attachment {
  id?: bigint
  filename?: string;
  content: File;


  constructor(content: File, user_team_id: bigint ) {
    this.content=content;
    this.id=user_team_id;

  }
}
