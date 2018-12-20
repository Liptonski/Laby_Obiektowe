import javafx.scene.chart.XYChart;

public class Wielomian {
    public XYChart.Series series = new XYChart.Series();
    public void draw(double [] coef , double begin, double end, double step){
        for(double i=begin; i<end; i+=step){
            series.getData().add(new XYChart.Data(i,function(i,coef)));
        }
    }
    public double function(double x, double [] coef ){
        double result=0;
        int len=coef.length;
        for(int i=0; i<len; i++){
            result+=Math.pow(x,len-1-i)*coef[i];
        }
        return result;
    }
}
