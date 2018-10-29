
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Shape> shapes = new LinkedList<Shape>();
        boolean check=true;
        int i =0;
        while (check) {
            System.out.print("1 - dodaj\n2 - kolejny ksztalt\n3 - wyjdz\n-: ");
            Scanner s = new Scanner(System.in);
            switch (s.nextInt()) {
                case 1:
                    System.out.print("1 - kwadrat\n2 - prostokat\n3 - trojkat\n4 - kolo\n-: ");
                    Scanner var = new Scanner(System.in);
                    switch (var.nextInt()) {
                        case 1:
                            Kwadrat k = new Kwadrat();
                            shapes.add(k);
                            break;
                        case 2:
                            Prostokat p = new Prostokat();
                            shapes.add(p);
                            break;
                        case 3:
                            Trojkat t = new Trojkat();
                            shapes.add(t);
                            break;
                        case 4:
                            Kolo kl = new Kolo();
                            shapes.add(kl);
                            break;
                    }
                    break;
                case 2:
                    shapes.get(i).draw();
                    i++;
                    if(i==shapes.size()) i=0;
                    break;
                case 3:
                    check=false;
                    break;
            }
        }
    }
}