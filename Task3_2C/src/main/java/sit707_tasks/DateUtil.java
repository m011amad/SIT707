package sit707_tasks;

/**
 * @author Ahsan Habib
 */
public class DateUtil {

    // Months in order 0-11 maps to January-December.
    private static String[] MONTHS = new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private int day, month, year;

    /*
     * Constructs object from given day, month and year.
     */
    public DateUtil(int day, int month, int year) {
        // Validate day/month/year
        if (day < 1 || day > 31)
            throw new RuntimeException("Invalid day: " + day + ", expected range 1-31");
        if (month < 1 || month > 12)
            throw new RuntimeException("Invalid month: " + month + ", expected range 1-12");
        if (year < 1700 || year > 2024)
            throw new RuntimeException("Invalid year: " + year + ", expected range 1700-2024");
        if (day > monthDuration(month, year))
            throw new RuntimeException("Invalid day: " + day + ", max day: " + monthDuration(month, year));

        this.day = day;
        this.month = month;
        this.year = year;
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

    /**
     * Increment one day.
     */
    public void increment() {
        int maxDays = monthDuration(month, year);
        if (day < maxDays) {
            //increase day
            day++;
        } else {
            // Last day of the month
            if (month == 12) {
                // December -> Increment year
                day = 1;
                month = 1;
                year++;
            } else {
                // Move to the next month
                day = 1;
                month++;
            }
        }
    }

    /**
     * Decrement one day from current date.
     */
    public void decrement() {
        if (day > 1) {
            // Normal case: Just decrement the day
            day--;
        } else {
            // Moving to the previous month
            if (month == 1) {
                // January -> Move to December of previous year
                month = 12;
                year--;
            } else {
                // Move to the previous month
                month--;
            }
            // Update day to last day of the new month
            day = monthDuration(month, year);
        }
    }

    /**
     * Calculate duration of current month of year.
     * @param month
     * @param year
     * @return Number of days in the given month
     */
    public static int monthDuration(int month, int year) {
        if (month == 2) {
            // February - Check for leap year
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            // April, June, September, November - 30 days
            return 30;
        }
        // All other months have 31 days
        return 31;
    }

    /**
     * Check if a given year is a leap year.
     * @param year
     * @return true if leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * User-friendly output.
     */
    public String toString() {
        return day + " " + MONTHS[month - 1] + " " + year;
    }
	
}
