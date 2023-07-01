package section5;

import java.sql.SQLOutput;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateAndTime {
    public static void main(String[] args) {

        //machine time
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); //기준시 UTC

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId = " + zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println("zonedDateTime = " + zonedDateTime);
        
        
        //time for human
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime birthDay = LocalDateTime.of(1989, Month.NOVEMBER, 06, 0, 0, 0);
        System.out.println("birthDay = " + birthDay);
        ZonedDateTime seoul = zonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("seoul = " + seoul);
        Instant now1 = instant.now();
        ZonedDateTime instantToZone = now1.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("instantToZone = " + instantToZone);

        //Period: for human
        //Duration: for machine
        LocalDate today = LocalDate.now();
        LocalDate comingBirthDay = LocalDate.of(2023, Month.NOVEMBER, 6);
        Period between = Period.between(today, comingBirthDay);
        System.out.println("today = " + today);
        System.out.println("comingBirthDay = " + comingBirthDay);
        System.out.println(between.getMonths() + " months " + between.getDays() + " days");
  /*      Period expresses the duration in years, months, and days,
  so information more than 30 days long will be put into months.
  If you want to calculate the total number of days, you can use between, which ChronoUnit provides.*/
        long between1 = ChronoUnit.DAYS.between(today, comingBirthDay);
        System.out.println("how many days left? = " + between1);


        Instant durationIns = Instant.now();
        Instant plus = durationIns.plus(10, ChronoUnit.SECONDS);
        Duration between2 = Duration.between(durationIns, plus);
        System.out.println("between2 = " + between2.getSeconds());
    }

}
