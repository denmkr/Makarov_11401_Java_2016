/**
 * Created by Denis on 25.02.16.
 */
public class Age {
    public int year;
    public int month;
    public int day;

    public void addAge(Age age) {
        year = year + age.year;
        month = month + age.month;
        day = day + age.day;
    }
}
