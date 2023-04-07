import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Qno1 extends Application {

    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Line line = new Line(); // instantiating Line class
        line.setStartX(0); // setting starting X point of Line
        line.setStartY(0); // setting starting Y point of Line
        line.setEndX(100); // setting ending X point of Line
        line.setEndY(200); // setting ending Y point of Line

        Rectangle rect = new Rectangle(); // instantiating Rectangle
        rect.setX(150); // setting the X coordinate of upper left //corner of rectangle
        rect.setY(150); // setting the Y coordinate of upper left //corner of rectangle
        rect.setWidth(100); // setting the width of rectangle
        rect.setHeight(100); // setting the height of rectangle

        // Drawing a Circle
        Circle circle = new Circle();

        // Setting the properties of the circle
        circle.setCenterX(300.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(50.0f);

        Ellipse ellipse = new Ellipse(350.0f, 200.0f, 50.0f, 30.f);

        Group root = new Group(); // Creating a Group
        root.getChildren().add(line); // adding the class object //to the group
        root.getChildren().add(rect);
        root.getChildren().add(circle);
        root.getChildren().add(ellipse);

        Scene scene = new Scene(root, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Line Example");
        primaryStage.show();
    }
}
