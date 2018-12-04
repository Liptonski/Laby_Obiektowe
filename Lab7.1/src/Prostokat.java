import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Prostokat implements Shape{
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.YELLOW);
        gc.fillRect(300,300,40,70);

    }
}
