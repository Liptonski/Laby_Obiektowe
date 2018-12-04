import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Scanner;

public class MyPanel extends Application implements EventHandler<ActionEvent> {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    Stage window;
    Scene start, rysunek;

    LinkedList<Shape> shapes = new LinkedList<Shape>();
    Kwadrat k = new Kwadrat();
    Prostokat p = new Prostokat();
    Trojkat t = new Trojkat();
    Kolo kl = new Kolo();
    int i =0;

    Canvas canvas = new Canvas(600, 800);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("Rysowanie");
        Group root1 = new Group();
        Group root2 = new Group();

        button1 = new Button("dodaj kwadrat");
        button2 = new Button("dodaj prostokat");
        button3 = new Button("dodaj trojkat");
        button4 = new Button("dodaj kolo");
        button5 = new Button("rysuj");
        button6 = new Button("wroc");

        button1.setLayoutX(50);
        button1.setLayoutY(100);

        button2.setLayoutX(250);
        button2.setLayoutY(100);

        button3.setLayoutX(450);
        button3.setLayoutY(100);

        button4.setLayoutX(650);
        button4.setLayoutY(100);

        button5.setLayoutX(400);
        button5.setLayoutY(300);

        button1.setOnAction(this);
        button2.setOnAction(this);
        button3.setOnAction(this);
        button4.setOnAction(this);
        button5.setOnAction(this);
        button6.setOnAction(this);

        root1.getChildren().addAll(button1, button2, button3, button4, button5);
        start = new Scene(root1, 800, 400);

        root2.getChildren().addAll(canvas, button6);
        rysunek = new Scene(root2);

        window.setScene(start);
        window.show();
    }
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button1)
            shapes.add(k);
        if (event.getSource() == button2)
            shapes.add(p);
        if (event.getSource() == button3)
            shapes.add(t);
        if (event.getSource() == button4)
            shapes.add(kl);
        if (event.getSource() == button5) {
            while (i != shapes.size()) {
                shapes.get(i).draw(gc);
                i++;
            }
            window.setScene(rysunek);
        }
        if (event.getSource() == button6)
            window.setScene(start);
    }
}