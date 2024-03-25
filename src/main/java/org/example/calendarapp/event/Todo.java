package org.example.calendarapp.event;

import java.time.ZonedDateTime;
import org.example.calendarapp.event.update.AbstractAuditableEvent;
import org.example.calendarapp.event.update.UpdateTodo;

public class Todo extends AbstractEvent {
  private String description;

  public Todo(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt, String description) {
    super(id, title, startAt, endAt);
    this.description = description;
  }

  @Override
  public boolean support(EventType type) {
    return type == EventType.TO_DO;
  }

  @Override
  public void print() {
    System.out.printf("[할 일] %s : %s%n", getTitle(), description);
  }

  @Override
  protected void update(AbstractAuditableEvent update) {
    UpdateTodo todoUpdate = (UpdateTodo) update;

    this.description = todoUpdate.getDescription();
  }
}
