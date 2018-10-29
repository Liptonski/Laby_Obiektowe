import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MicroDVD {
    FileWriter output;
    FileReader input;
    public void delay(String in, String out, int delay, int fps) throws NotIntException, BadFramesException{
        try {
            input = new FileReader(in);
            output = new FileWriter(out);
            BufferedReader br = new BufferedReader(input);
            PrintWriter pw = new PrintWriter(output);
            String str;
            int begin = 0;
            int end = 0;
            int lineCounter = 0;
            while ((str = br.readLine()) != null) {
                int i = 1;
                if ((int) str.charAt(0) == 123) {
                    while ((int) str.charAt(i) != 125) {
                        if ((int) str.charAt(i) < 48 || (int) str.charAt(i) > 57)
                            throw new NotIntException("'data between {...}" +
                                    "is not integer' in line - " + lineCounter + " : " + str);
                        i++;
                    }
                    begin = Integer.parseInt(str.substring(1, i));
                }
                int j = i + 1;
                if ((int) str.charAt(j) == 123) {
                    while ((int) str.charAt(j + 1) != 125) {
                        if ((int) str.charAt(j+1) < 48 || (int) str.charAt(j+1) > 57)
                            throw new NotIntException("'data between {...}" +
                                    "is not integer' in line - " + lineCounter + " : " + str);
                        j++;
                    }

                    end = Integer.parseInt(str.substring(i + 2, j+1));
                }
                if (begin > end)
                    throw new BadFramesException("begin frame is higher than end in line - " + lineCounter + " : " + str);
                begin = begin + delay / 1000 * fps;
                end = end + delay / 1000 * fps;
                pw.println("{" + begin + "}{" + end + "}" + str.substring(j+2, str.length()));
                lineCounter++;
            }
            br.close();
            pw.close();
            input.close();
            output.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}