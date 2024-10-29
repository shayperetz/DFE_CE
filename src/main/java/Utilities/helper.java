package Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class helper extends base
{

    public static String getDateTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        System.out.println(dtf.format(now));
        return dateTime;
    }
    public static void wait_seconds(int mSeconds)
    {
        try {
            Thread.sleep(mSeconds);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
    }


}
