###DateFormatter
Consider the code snippet
```
LocalDate date = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy M dd");
String format = date.format(formatter);
System.out.println(format);
```
yyyy M and dd represents the year, month and days respectively. Let's take for instance the month,
if it is only one letter, it will print '2024 7 07', if two, it will be '2024 07 07', 3 will give 
'2024 Jul 07', 4 will give '2024 July 07', 5 gives '2024 J 07', while 6 will throw
java.lang.IllegalArgumentException: Too many pattern letters: M.\
Increasing the letters for the year only adds zero to the front of the year if the number of letters have exceeded the current length of the letters in the year.\
For the d part, if the number of d exceeds 2, it will throw\
java.lang.IllegalArgumentException: Too many pattern letters: d

The important codes for printing out dates are 'm, M, d, D, e, y, u, s, S, h, H, and z, a'
m: minute-of-hour, M: month-of-year, d: day-of-month, D: day-of-year, e: localized day-of-week, y: year-of-era, u: year, s: second-of-minute, S: fraction-of-second,
h: clock-hour-of-am-pm (1-12), H: hour-of-day (0-23), z: time-zone name, a: am-pm-of-day