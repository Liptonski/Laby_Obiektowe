import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        int delay = Integer.parseInt(args[2]);
        int fps = Integer.parseInt(args[3]);
        MicroDVD dvd = new MicroDVD();
        try {
            dvd.delay(args[0],args[1],delay, fps);
        } catch (NotIntException | BadFramesException e) {
            e.printStackTrace();
        }
    }
}