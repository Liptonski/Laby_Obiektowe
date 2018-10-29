public class Kolo implements Shape {
    @Override
    public void draw() {
        int r=5;
        for(int i = 0; i<r; i++){
            for(int j=0; j<r-i-1; j++){
                System.out.print(" ");
            }
            for(int z=0; z<1+i*2;z++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for(int i = r-2; i>=0; i--){
            for(int j=0; j<r-i-1; j++){
                System.out.print(" ");
            }
            for(int z=0; z<1+i*2;z++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}