package org.example.calendarapp;

import java.io.IOException;
import java.util.List;
import org.example.calendarapp.event.Meeting;
import org.example.calendarapp.event.NoDisturbance;
import org.example.calendarapp.event.OutOfOffice;
import org.example.calendarapp.event.Schedule;
import org.example.calendarapp.event.Todo;
import org.example.calendarapp.reader.EventCsvReader;
import org.example.calendarapp.reader.RawCsvReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalendarAppApplication {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(CalendarAppApplication.class, args);

    Schedule schedule = new Schedule();

    EventCsvReader csvReader = new EventCsvReader(new RawCsvReader());
    String meetingCsvPath = "/data/meeting.csv";
    String noDisturbanceCsvPath = "/data/no_disturbance.csv";
    String outOfOfficeCsvPath = "/data/out_of_office.csv";
    String toDoCsvPath = "/data/to_do.csv";

    List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
    meetings.forEach(schedule::add);

    List<NoDisturbance> noDisturbances = csvReader.readNoDisturbances(noDisturbanceCsvPath);
    noDisturbances.forEach(schedule::add);

    List<OutOfOffice> outOfOffices = csvReader.readOutOfOffices(outOfOfficeCsvPath);
    outOfOffices.forEach(schedule::add);

    List<Todo> todos = csvReader.readTodos(toDoCsvPath);
    todos.forEach(schedule::add);

    schedule.printAll();
  }
}
