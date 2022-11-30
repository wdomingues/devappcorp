package hello;

import java.util.Calendar;
import java.util.Locale;

import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.LONG;

public class TimeManipulation {
    public static final char AM = 'M';
    public static final char PM = 'A';
    public static final char EVE = 'E';

    protected static Calendar getCalInstance(){
        return Calendar.getInstance();
    }

    protected static String getWeekDay(Calendar time, String lang){
        Locale locale = new Locale("en");
        switch (lang){
            case "pt":
                locale = new Locale(lang, "BR");
                break;
            case "en":
                locale = new Locale(lang, "US");
                break;
            case "de":
                locale = new Locale(lang, "DE");
                break;
            case "fr":
                locale = new Locale(lang, "FR");
                break;
        }
        return time.getDisplayName(DAY_OF_WEEK, LONG, locale);
    }

    /**
     * Determines if we're in the morning or afternoon
     *
     * @param time the time to decode.
     * @return char representing the period of the day.
     */
    protected static char getPeriodOfDay(Calendar time) {
        char periodOfDay;
        int hour = time.get(Calendar.HOUR_OF_DAY);
        if (hour < 12) {
            periodOfDay = AM;
        } else if (hour < 18) {
            periodOfDay = PM;
        } else {
            periodOfDay = EVE;
        }
        return periodOfDay;
    }

    protected static String PTBGreetings(char periodOfDay) {
        switch (periodOfDay){
            case 'M':
                return "Bom dia";
            case 'A':
                return "Boa tarde";
            case 'E':
                return "Boa noite";
        }
        return "";
    }

    protected static String ENGGreetings(char periodOfDay) {
        switch (periodOfDay){
            case 'M':
                return "Good morning";
            case 'A':
                return "Good afternoon";
            case 'E':
                return "Good evening";
        }
        return "";
    }

    protected static String GERGreetings(char periodOfDay) {
        switch (periodOfDay){
            case 'M':
                return "Guten morgen";
            case 'A':
                return "Guten nachmittag";
            case 'E':
                return "Guten abend";
        }
        return "";
    }

    protected static String FREGreetings(char periodOfDay) {
        switch (periodOfDay){
            case 'M':
                return "Bonjour";
            case 'A':
                return "Bon après-midi";
            case 'E':
                return "Bonsoir";
        }
        return "";
    }

    protected static String getGreeting(String lang, char periodOfDay) {
        switch (lang){
            case "pt":
                return PTBGreetings(periodOfDay);
            case "en":
                return ENGGreetings(periodOfDay);
            case "de":
                return GERGreetings(periodOfDay);
            case "fr":
                return FREGreetings(periodOfDay);
        }
        return "";
    }
}
