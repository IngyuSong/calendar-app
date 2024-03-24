# 일정 관리 프로그램
- 구글 캘린더 등 일정을 관리할 수 있는 서비스입니다.
- Java 기반으로 작성되었으며 콘솔에서 결과를 확인할 수 있습니다.

# 요구사항
일정 관리 프로그램의 요구사항은 다음과 같습니다.

## 일정의 유형
- "미팅", "할 일", "방해 금지 시간", "외출"에 대한 일정을 관리할 수 있다.
  - 미팅: `meeting`
  - 할 일: `to-do`
  - 방해 금지 시간: `no-disturbance`
  - 외출: `out-of-office`

## 등록 (Create)
- 일정을 등록할 수 있다.
  - 겹치는 일정이 존재하면 일정을 등록할 수 없다.
- 일정을 `.csv` 파일로 대량 등록할 수 있다.

## 검색/조회 (Read)
- 일정을 ID, 이름, 기간으로 검색할 수 있다.
- 특정 일자를 입력하면 해당 일자에 등록된 일정을 요약하여 보여준다.

## 수정 (Update)
- 일정을 수정할 수 있다.
- 삭제된 일정은 수정할 수 없다.

## 삭제 (Delete)
- 일정을 삭제할 수 있다.
- Soft-delete 로 처리한다.

# 시스템 디자인 및 설계

## 도메인

```java
public enum EventType {
  MEETING,
  TO_DO,
  NO_DISTURBANCE,
  OUT_OF_OFFICE,
  ;
}

public interface Event {

  voic print();
}

public abstract class AbstractEvent implements Event {

  private int id;
  private String title;
  private ZonedDateTime startAt;
  private ZonedDateTime endAt;

  private boolean deleteYn;

  private ZonedDateTime createdAt;
  private ZonedDateTime modifiedAt;

  protected abstract void update(); // 각 세부 이벤트 타입에서 필요한 수정을 하기 위함
}

public class Meeting extends AbstractEvent {
  private String description;
  private Set<String> participants;
}

public class Todo extends AbstractEvent {
  
}

public class OutOfOffice extends AbstractEvent {
  
}

public class NoDisturbance extends AbstractEvent {
  
}
```
여러 Event 를 관리하는 객체는 Schedule

## CSV 읽기
- open-csv
- https://www.baeldung.com/opencsv
