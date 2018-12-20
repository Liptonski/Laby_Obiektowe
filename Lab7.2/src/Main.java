import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stage){
        stage.setTitle("Wykres wielomianu");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        yAxis.setLabel("y");
        final LineChart<Number,Number> wielomian =
                new LineChart<Number,Number>(xAxis,yAxis);
        Wielomian w = new Wielomian();
        w.draw(new double[]{1,1,1}, -11, 11, 0.25);
        Scene scene  = new Scene(wielomian,800,600);
        wielomian.setTitle("wielomian");
        wielomian.getData().add(w.series);
        wielomian.setCreateSymbols(false);

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String [] args){
        launch(args);
    }
}
