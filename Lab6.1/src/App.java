import java.util.Scanner;

public class App {
    private static void pressAnyKeyToContinue()
    {
        System.out.println("Wciśnij Enter aby kontynuować...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public static void main(String [] args){
        DB db = new DB();

        Scanner decision = new Scanner(System.in);
        Scanner var = new Scanner(System.in);
        boolean check=true;
        while(check) {
            System.out.println("Co chcesz zrobic: ");
            System.out.print("1. Wyświetl wszystko\n2. Wyswietl tytuły danego autora\n" +
                    "3. Wyświetl tytuły danego ISBN\n4. Dodaj książkę\n5. Zakończ\n? : ");
            switch (decision.nextInt()) {
                case 1:
                    db.listAll();
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    System.out.println("Podaj Imię i Nazwisko autora: ");
                    String name = var.nextLine();
                    db.listByAuthor(name);
                    pressAnyKeyToContinue();
                    break;
                case 3:
                    System.out.print("Podaj 13 cyfrowy numer ISBN: ");
                    String number = var.nextLine();
                    db.listByISBN(number);
                    pressAnyKeyToContinue();
                    break;
                case 4:
                    System.out.println("Podaj Kolejne parametry książki: ");
                    System.out.println("ISBN: ");
                    String ISBN = var.nextLine();
                    System.out.println("Tytuł: ");
                    String title = var.nextLine();
                    System.out.println("Autor: ");
                    String author = var.nextLine();
                    System.out.println("Rok wydania: ");
                    int year = var.nextInt();
                    try{
                        db.insertBook(ISBN, title, author, year);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    pressAnyKeyToContinue();
                    break;
                case 5:
                    check=false;
                default:
                    check = false;
                    break;
            }
        }
    }
}
