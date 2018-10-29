public class Trojkat implements Shape {
    @Override
    public void draw() {
        for(int i = 0; i<7; i++){
            for(int j=0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}