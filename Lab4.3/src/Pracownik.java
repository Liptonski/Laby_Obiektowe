public abstract class Pracownik {
    Pesel p;
    double wynagrodzenieBrutto;
    public abstract double wynagrodzenieNetto();
    public abstract String getPesel();
    Pracownik(){};
}