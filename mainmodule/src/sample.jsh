int i = 5;
"abc" == "abc"
int time = 5;
String ampm = "PM";
if (ampm.equalsIgnoreCase("am")) {
    System.out.println("It is morning");
} else {
     System.out.println("It is not morning");
}
void TimeOfDay(String periodOfDay, int time) {
    if (time < 1 || time > 12) {
        System.out.println("Time range is between 1 to 12(both inclusive)");
    } else if (timeOfDay.equalsIgnoreCase("afternoon") || timeOfDay.equalsIgnoreCase("evening")) {
        System.out.println("Time is " + time + "pm");
    } else if (timeOfDay.equalsIgnoreCase("morning")) {
        System.out.println("Time is " + time + "am");
    } else {
        System.out.println("Period of day is invalid");
    }
}
TimeOfDay("morning", 5);
timeOfDay("morning", 5);
timeOfDay("morning", 12);
timeOfDay("morning", 0);
void timeOfDay(String periodOfDay, int time) {
    if (time < 1 || time > 12) {
        System.out.println("Time range should be between 1 and 12(both inclusive)");
    } else if (periodOfDay.equalsIgnoreCase("afternoon") || periodOfDay.equalsIgnoreCase("evening")) {
        System.out.println("Time is " + time + "pm");
    } else if (periodOfDay.equalsIgnoreCase("morning")) {
        System.out.println("Time is " + time + "am");
    } else {
        System.out.println("Period of day is invalid");
    }
}
timeOfDay("morning", 12);
timeOfDay("morning", 0);
timeOfDay("morning", -1);
timeOfDay("morning", 8);
timeOfDay("afternoon", 8);
timeOfDay("evening", 8);