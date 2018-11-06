package appl;

import excp.NotIntFactorialException;
import excp.TooBigNumberException;
import excp.ZeroDivideException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Calculator implements Saveable {
    private double result;
    public Calculator(){
        result=0;
    }
    public void Add(double x){
        result+=x;
    }
    public void Substract(double x){
        result-=x;
    }
    public void Multiply(double x){
        result*=x;
    }
    public void Divide(double x) throws ZeroDivideException{
        if(x==0) throw new ZeroDivideException("Can't divide by zero");
        result/=x;
    }
    public void Factorial() throws TooBigNumberException, NotIntFactorialException {
        if(result>10) throw new TooBigNumberException("Number must be lower than 10");
        if(result%1!=0) throw new NotIntFactorialException("tylko inty w silni"); //braklo czasu na result not int :/
        double help=1;
        for(int i = 2; i<=result; i++){
            help *= i;
        }
        result = help;
    }
    public void SaveToFile(double x, String filename){
        try{
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);

            String ans = String.valueOf(x);
            pw.println(ans);
            pw.close();
        }
        catch (IOException e){
            System.out.print("wrong filename");
        }
    }
    public void SaveToFile(String filename){
        SaveToFile(result, filename);
    }
    public static void main(String [] args){
        try{
            Calculator cl = new Calculator();
            cl.Add(3);
            cl.Factorial();
            cl.Add(10);
            cl.Substract(4.5);
            cl.Multiply(3);
            cl.Divide(2);
            cl.SaveToFile("wynik.txt");
        }
        catch (TooBigNumberException  | ZeroDivideException  | NotIntFactorialException e){
            e.printStackTrace();
        }
    }
}
