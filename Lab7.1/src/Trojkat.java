import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Trojkat implements Shape{
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.PURPLE);
        gc.fillPolygon(new double[]{400,450,425},new double[]{500,500,650},3 );
    }
}