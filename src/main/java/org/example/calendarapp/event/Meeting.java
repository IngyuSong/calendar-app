package org.example.calendarapp.event;

import java.time.ZonedDateTime;
import java.util.Set;
import org.example.calendarapp.event.update.AbstractAuditableEvent;
import org.example.calendarapp.event.update.UpdateMeeting;

public class Meeting extends AbstractEvent {

  private Set<String> participants;
  private String meetingRoom;
  private String agenda;

  public Meeting(int id, String title,
      ZonedDateTime startAt, ZonedDateTime endAt,
      Set<String> participants, String meetingRoom, String agenda) {
    super(id, title, startAt, endAt);

    this.participants = participants;
    this.meetingRoom = meetingRoom;
    this.agenda = agenda;
  }

  @Override
  public boolean support(EventType type) {
    return type == EventType.MEETING;
  }

  @Override
  public void print() {
    System.out.printf("[회의] %s : %s%n", getTitle(), agenda);
  }

  @Override
  protected void update(AbstractAuditableEvent update) {
    UpdateMeeting meetingUpdate = (UpdateMeeting) update;

    this.participants = meetingUpdate.getParticipants();
    this.meetingRoom = meetingUpdate.getMeetingRoom();
    this.agenda = meetingUpdate.getAgenda();
  }
}
