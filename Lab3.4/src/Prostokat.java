public class Prostokat implements Shape{
    @Override
    public void draw() {
        for(int i = 0; i<4; i++){
            for(int j=0; j<10; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}