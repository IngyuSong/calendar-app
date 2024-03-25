package org.example.calendarapp;

import java.io.IOException;
import java.util.List;
import org.example.calendarapp.event.Meeting;
import org.example.calendarapp.event.Schedule;
import org.example.calendarapp.reader.EventCsvReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalendarAppApplication {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(CalendarAppApplication.class, args);

    Schedule schedule = new Schedule();

    EventCsvReader csvReader = new EventCsvReader();
    String meetingCsvPath = "/data/meeting.csv";

    List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
    meetings.forEach(schedule::add);

    schedule.printAll();
  }
}
