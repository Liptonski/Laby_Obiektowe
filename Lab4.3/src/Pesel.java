public class Pesel {
    String p;
    Pesel(String pes){
        this.p=pes;
    }
    boolean check(){
        if(p.length()!=11) return false;
        if(((9*(p.charAt(0)-'0') + 7*(p.charAt(1)-'0') + 3*(p.charAt(2)-'0') + (p.charAt(3)-'0') + 9*(p.charAt(4)-'0')
                + 7*(p.charAt(5)-'0') + 3*(p.charAt(6)-'0') + (p.charAt(7)-'0')
                + 9*(p.charAt(8)-'0') + 7*(p.charAt(9)-'0'))%10)
                !=(p.charAt(10)-'0')) return false;
        return true;
    }
}