package org.example.calendarapp.event.update;

import java.time.ZonedDateTime;

public class UpdateNoDisturbance extends AbstractAuditableEvent {
  public UpdateNoDisturbance(String title, ZonedDateTime startAt, ZonedDateTime endAt) {
    super(title, startAt, endAt);
  }
}
