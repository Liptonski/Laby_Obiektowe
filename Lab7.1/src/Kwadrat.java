import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Kwadrat implements Shape{
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        gc.fillRect(100,200, 40,40);
    }
}