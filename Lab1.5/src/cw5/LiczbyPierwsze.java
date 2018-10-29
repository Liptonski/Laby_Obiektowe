package cw5;

import java.util.ArrayList;

public class LiczbyPierwsze {
    public ArrayList<Integer> primes = new ArrayList<Integer>();
    public boolean isPrime(int n){
        for(int i=2; i*i<n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
    LiczbyPierwsze(){
        System.out.print("Podaj liczbe: ");
        int num = Input.getNumber();
        for(int i=2; i<num; i++){
            if(isPrime(i)) primes.add(i);
        }
    }
}