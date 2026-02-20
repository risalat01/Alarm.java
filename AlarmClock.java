import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable {

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner sc ;

    AlarmClock(LocalTime alarmTime, String filePath,  Scanner sc) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.sc = sc;
    }

    @Override
    public void run() {

        while (LocalTime.now().isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);
                int hour = LocalTime.now().getHour();
                int minutes = LocalTime.now().getMinute();
                int seconds = LocalTime.now().getSecond();
                System.out.printf("\r%02d:%02d:%02d", hour, minutes, seconds);

            } catch (InterruptedException e) {
                System.out.println("Thread was Interrupted");
                ;
            }
        }
        System.out.print(" **NOISE BEEPS** ");

        playSound(filePath);

    }

    public void playSound(String filePath) {

        File file = new File(filePath);
        try ( AudioInputStream audio = AudioSystem.getAudioInputStream(file)){
Clip clip = AudioSystem.getClip();
clip.open(audio);
clip.start();
            System.out.println("Press **ENTER** To Stop The Music/ALARM");
            sc.nextLine();
            clip.stop();
            sc.close();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("UNSUPPORTED AUDIO !");
        } catch (IOException e) {
            System.out.println("INPUT / OUTPUT ERROR");
        } catch (NullPointerException e) {
            System.out.println("null pointer Error");
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

    }
}
