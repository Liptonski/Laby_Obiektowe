import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<Punkt3D> punkty = new LinkedList<Punkt3D>();
    public static void main(String[] args) {
        Scanner decision = new Scanner(System.in);
        Scanner var = new Scanner(System.in);
        boolean check=true;
        while(check) {
            System.out.print("1. Wczytaj punkt 3D\n2. Wyświetl wszystkie punkty\n" +
                    "3. Oblicz odleglosc\n4. zakoncz\n? : ");
            switch (decision.nextInt()) {
                case 1:
                    System.out.print("Podaj x, y, z: ");
                    int x = var.nextInt();
                    int y = var.nextInt();
                    int z = var.nextInt();
                    punkty.add(new Punkt3D(x, y, z));
                    break;
                case 2:
                    for (int i = 0; i < punkty.size(); i++) {
                        System.out.print(punkty.get(i).x + " ");
                        System.out.print(punkty.get(i).y + " ");
                        System.out.print(punkty.get(i).z + " \n");
                    }
                    break;
                case 3:
                    System.out.print("Podaj x, y, z punktu do obliczenia: ");
                    int xx = var.nextInt();
                    int yy = var.nextInt();
                    int zz = var.nextInt();
                    System.out.print("Podaj index punktu z listy: ");
                    int index = var.nextInt();
                    Punkt3D temp = new Punkt3D(xx,yy,zz);
                    System.out.print(punkty.get(index).distance(temp) + "\n");
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    check = false;
                    break;
            }
        }
    }
}
