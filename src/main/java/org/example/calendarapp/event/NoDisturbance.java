package org.example.calendarapp.event;

import java.time.ZonedDateTime;
import org.example.calendarapp.event.update.AbstractAuditableEvent;

public class NoDisturbance extends AbstractEvent {
  public NoDisturbance(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
    super(id, title, startAt, endAt);
  }

  @Override
  protected void update(AbstractAuditableEvent update) {

  }

  @Override
  public boolean support(EventType type) {
    return type == EventType.NO_DISTURBANCE;
  }

  @Override
  public void print() {
    System.out.printf("[방해 금지] %s%n", getTitle());
  }

}
