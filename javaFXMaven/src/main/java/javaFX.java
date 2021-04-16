import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class javaFX extends Application {
    public void start(Stage stage) throws Exception {
        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        canvas.setPrefSize(200,200);
        Circle circle = new Circle(50, Color.NAVY);
        run(circle);
        circle.relocate( 50,50);
        canvas.getChildren().add(circle);
        Scene scene = new Scene(canvas, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void run(Shape shape){
        Timer timer = new Timer(true);
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                move(shape,5,5);
            }
        };
        timer.schedule(task1,0,1000/60);
    }

    private void move(Shape shape,int x,int y){
        shape.setLayoutX(shape.getLayoutX()+x);
        shape.setLayoutY(shape.getLayoutY()+y);
    }
}
