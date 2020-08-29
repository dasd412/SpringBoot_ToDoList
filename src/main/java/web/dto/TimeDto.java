package web.dto;


import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Getter
public class TimeDto {

    private int year;
    private int monthValue;
    private int dayOfMonth;
    private DayOfWeek dayOfWeek;

    public TimeDto(LocalDateTime dateTime){
        year=dateTime.getYear();
        monthValue=dateTime.getMonthValue();
        dayOfMonth=dateTime.getDayOfMonth();
        dayOfWeek=dateTime.getDayOfWeek();
    }
}
