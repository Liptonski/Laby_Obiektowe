public class Main {

    public static void main(String[] args) {
        Kadry k = new Kadry();
        k.add("98010808279", 's');
        k.add("44051401359", 'p');
        k.changeBrutto("44051401359", 5500);
        k.sort();
        System.out.print(k.getNetto("44051401359"));
    }
}