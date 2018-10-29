import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Kadry {
    LinkedList<Pracownik> pracownicy = new LinkedList<Pracownik>();
    Kadry(){}
    public void add(String pesel, char type){
        if(type=='s') {
            Pracownik s = new Student(pesel);
            pracownicy.add(s);
        }
        if(type=='p') {
            Pracownik p = new PracownikEtatowy(pesel);
            pracownicy.add(p);
        }
    }
    public void remove(String pesel){
        for(int i=0;i<pracownicy.size(); i++){
            if(pracownicy.get(i).getPesel()== pesel) pracownicy.remove(i);
        }
    }
    public int search(String pesel){
        for(int i=0;i<pracownicy.size(); i++){
            if(pracownicy.get(i).getPesel()== pesel) return i;
        }
        return -1;
    }
    public void changeBrutto(String pesel, double newBrutto){
        for(int i=0;i<pracownicy.size(); i++){
            if(pracownicy.get(i).getPesel()== pesel){
                pracownicy.get(i).wynagrodzenieBrutto = newBrutto;
            }
        }
    }
    public double getBrutto(String pesel){
        for(int i=0;i<pracownicy.size(); i++){
            if(pracownicy.get(i).getPesel()== pesel){
                return pracownicy.get(i).wynagrodzenieBrutto;
            }
        }
        return -1;
    }
    public double getNetto(String pesel){
        for(int i=0;i<pracownicy.size(); i++){
            if(pracownicy.get(i).getPesel()== pesel){
                return pracownicy.get(i).wynagrodzenieNetto();
            }
        }
        return -1;
    }
    class BruttoComparator implements Comparator<Pracownik> {
        @Override
        public int compare(Pracownik a, Pracownik b) {
            return a.wynagrodzenieBrutto < b.wynagrodzenieBrutto ? -1 :
                    a.wynagrodzenieBrutto == b.wynagrodzenieBrutto ? 0 : 1;
        }
    }
    public void sort(){
        Collections.sort(pracownicy, new BruttoComparator());
    }
}