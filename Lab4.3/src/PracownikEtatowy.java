public class PracownikEtatowy extends Pracownik {
    @Override
    public double wynagrodzenieNetto(){
        return 0.72*wynagrodzenieBrutto;
    }
    PracownikEtatowy(String pesel){
        p = new Pesel(pesel);
        wynagrodzenieBrutto=5000;
    }
    public String getPesel(){
        return p.p;
    }
}