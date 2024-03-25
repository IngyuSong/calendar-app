package org.example.calendarapp.event;

import java.time.ZonedDateTime;
import org.example.calendarapp.event.update.AbstractAuditableEvent;

public class OutOfOffice extends AbstractEvent {
  public OutOfOffice(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
    super(id, title, startAt, endAt);
  }

  @Override
  protected void update(AbstractAuditableEvent update) {

  }

  @Override
  public boolean support(EventType type) {
    return type == EventType.OUT_OF_OFFICE;
  }

  @Override
  public void print() {
    System.out.printf("[부재중] %s%n", getTitle());
  }

}
