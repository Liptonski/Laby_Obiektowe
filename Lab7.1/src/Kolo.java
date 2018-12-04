import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Kolo implements Shape{
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillOval(60,60,30,30);
    }
}