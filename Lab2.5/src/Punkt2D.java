
import static java.lang.Math.sqrt;

public class Punkt2D {
    double x,y;
    Punkt2D(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    public double distance(Punkt2D p){
        return sqrt((p.x-x)*(p.x-x) + (p.y-y)*(p.y-y));
    }
}
