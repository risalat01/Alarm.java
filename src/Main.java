



import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // JAVA ALARM CLOCK
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter DateTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        while(alarmTime == null) {

            try {
                System.out.println("Enter the Time for Alarm( HH-MM-SS)");
                String inputTime = sc.nextLine();
                alarmTime = LocalTime.parse(inputTime, DateTime);
                System.out.println("Alarm set for " + alarmTime);

            } catch (DateTimeParseException e) {

                System.out.println("Enter Valid Time ");
            }
        }


        String filePath = "Kafka-320kbps.wav";
        AlarmClock Clock = new AlarmClock(alarmTime, filePath, sc);
        Thread alarmThread = new Thread(Clock);
        alarmThread.start();


    }
;}