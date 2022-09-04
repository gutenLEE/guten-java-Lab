package algorithm;

/**
 * @author gutenlee
 * @since 2022/09/04
 */
public class TimeIncludeNumberThree {

    private int hour;
    private int minutes;
    private int seconds;
    public TimeIncludeNumberThree(int hour) {
        this.hour = hour;
        this.minutes = 59;
        this.seconds = 59;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int countIfInclude_3() {
        if (hour == 0) hour = 1;
        int minutesInclude_3 = count(minutes);
        int secondsInclude_3 = count(seconds);

        return hour * minutesInclude_3 * secondsInclude_3;
    }

    private int count(int target){
        int count = 0;
        for (int i = 0; i <= target; i++) {
            String s = Integer.toString(i);
            if (s.contains("3")) count++;
        }
        return count;
    }
}
