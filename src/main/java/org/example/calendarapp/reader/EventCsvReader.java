package org.example.calendarapp.reader;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.example.calendarapp.event.Meeting;
import org.example.calendarapp.event.NoDisturbance;
import org.example.calendarapp.event.OutOfOffice;
import org.example.calendarapp.event.Todo;

public class EventCsvReader {

  private final RawCsvReader rawCsvReader;

  public EventCsvReader(RawCsvReader rawCsvReader) {
    this.rawCsvReader = rawCsvReader;
  }

  public List<Meeting> readMeetings(String path) throws IOException {
    List<Meeting> result = new ArrayList<>();

    // 데이터를 읽는 부분
    List<String[]> read = rawCsvReader.readAll(path);
    for (int i = 0; i < read.size(); i++) {
      if (skipHeader(i)) {
        continue;
      }

      String[] each = read.get(i);

      // Meeting 으로 변환 부분
      result.add(new Meeting(
          Integer.parseInt(each[0]),
          each[2],
          ZonedDateTime.of(LocalDateTime.parse(
              each[6], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
              ZoneId.of("Asia/Seoul")
          ),
          ZonedDateTime.of(LocalDateTime.parse(
                  each[7], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
              ZoneId.of("Asia/Seoul")
          ),
          new HashSet<>(Arrays.asList(each[3].split(","))),
          each[4],
          each[5]
        )
      );
    }

    return result;
  }

  public List<NoDisturbance> readNoDisturbances(String path) throws IOException {
    List<NoDisturbance> result = new ArrayList<>();

    List<String[]> read = rawCsvReader.readAll(path);
    for (int i = 0; i < read.size(); i++) {
      if (skipHeader(i)) {
        continue;
      }

      String[] each = read.get(i);

      result.add(new NoDisturbance(
              Integer.parseInt(each[0]),
              each[2],
              ZonedDateTime.of(LocalDateTime.parse(
                      each[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                  ZoneId.of("Asia/Seoul")
              ),
              ZonedDateTime.of(LocalDateTime.parse(
                      each[4], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                  ZoneId.of("Asia/Seoul")
              )
          )
      );
    }

    return result;
  }

  public List<OutOfOffice> readOutOfOffices(String path) throws IOException {
    List<OutOfOffice> result = new ArrayList<>();

    List<String[]> read = rawCsvReader.readAll(path);
    for (int i = 0; i < read.size(); i++) {
      if (skipHeader(i)) {
        continue;
      }

      String[] each = read.get(i);

      result.add(new OutOfOffice(
              Integer.parseInt(each[0]),
              each[2],
              ZonedDateTime.of(LocalDateTime.parse(
                      each[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                  ZoneId.of("Asia/Seoul")
              ),
              ZonedDateTime.of(LocalDateTime.parse(
                      each[4], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                  ZoneId.of("Asia/Seoul")
              )
          )
      );
    }

    return result;
  }

  public List<Todo> readTodos(String path) throws IOException {
    List<Todo> result = new ArrayList<>();

    List<String[]> read = rawCsvReader.readAll(path);
    for (int i = 0; i < read.size(); i++) {
      if (skipHeader(i)) {
        continue;
      }

      String[] each = read.get(i);

      result.add(new Todo(
              Integer.parseInt(each[0]),
              each[2],
              ZonedDateTime.of(LocalDateTime.parse(
                      each[4], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                  ZoneId.of("Asia/Seoul")
              ),
              ZonedDateTime.of(LocalDateTime.parse(
                      each[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                  ZoneId.of("Asia/Seoul")
              ),
          each[3]
          )
      );
    }

    return result;
  }


  private boolean skipHeader(int i) {
    return i == 0;
  }

}
