package task007;

import org.springframework.stereotype.Component;

/**
 * Created by Denis on 25.02.16.
 */
@Component
public class Age {
    private int year;
    private int month;
    private int day;

    public Age() {
    }

    public Age(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addAge(Age age) {
        year = year + age.getYear();
        month = month + age.getMonth();
        day = day + age.getDay();
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
