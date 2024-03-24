package org.example.calendarapp;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.example.calendarapp.event.AbstractEvent;
import org.example.calendarapp.event.Event;
import org.example.calendarapp.event.EventType;
import org.example.calendarapp.event.Meeting;
import org.example.calendarapp.event.Schedule;
import org.example.calendarapp.event.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalendarAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(CalendarAppApplication.class, args);

    Schedule schedule = new Schedule();

    HashSet<String> participants = new HashSet<>();
    participants.add("danny.kim");

    Meeting meeting1 = new Meeting(
        1, "meeting1", ZonedDateTime.now(), ZonedDateTime.now().plusHours(1), participants, "meetingRoomA", "스터디"
    );
    schedule.add(meeting1);

    Todo todo1 = new Todo(
        2, "todo1", ZonedDateTime.now().plusHours(3), ZonedDateTime.now().plusHours(4), "할 일 적기"
    );
    schedule.add(todo1);

    Todo todo2 = new Todo(
        3, "todo2", ZonedDateTime.now().plusHours(5), ZonedDateTime.now().plusHours(4), "할 일 적기"
    );
    schedule.add(todo2);

    schedule.printAll();


  }

}
