package org.example.calendarapp.event.update;

import java.time.ZonedDateTime;

public abstract class AbstractAuditableEvent {
  private final String title;
  private final ZonedDateTime startAt;
  private final ZonedDateTime endAt;

  protected AbstractAuditableEvent(String title, ZonedDateTime startAt, ZonedDateTime endAt) {
    this.title = title;
    this.startAt = startAt;
    this.endAt = endAt;
  }

  public ZonedDateTime getEndAt() {
    return endAt;
  }

  public ZonedDateTime getStartAt() {
    return startAt;
  }

  public String getTitle() {
    return title;
  }
}
