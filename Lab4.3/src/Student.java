public class Student extends Pracownik{
    @Override
    public double wynagrodzenieNetto(){
        return 0.77*wynagrodzenieBrutto;
    }
    Student(String pesel){
        p = new Pesel(pesel);
        wynagrodzenieBrutto=3000;
    }
    public String getPesel(){
        return p.p;
    }
}