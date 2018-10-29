import static java.lang.Math.sqrt;

public class Punkt3D extends Punkt2D {
    double z;
    Punkt3D(double x, double y, double z){
        super(x,y);
        this.z=z;
    }
    public double getZ(){
        return z;
    }
    public void setZ(double z){
        this.z=z;
    }
    public double distance(Punkt3D p){
        return sqrt((p.x-x)*(p.x-x) + (p.y-y)*(p.y-y) + (p.z-z)*(p.z-z));
    }
}
