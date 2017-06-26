import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Challenge5
{
    private static TextField Ranking;
    private static TextField Name;
    private static TextField Country;
    
    public static void main(String args[])
    {
        launchFX();
    }

    private static void launchFX()
    {
        new JFXPanel();
        Platform.runLater(() -> initialiseGUI());
    }

    private static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("Top Universities by Michael");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth (1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show();

        Ranking = new TextField();
        Ranking.setText("Enter ranking");
        Ranking.setLayoutX(100);
        Ranking.setLayoutY(10);
        Ranking.setPrefWidth(250);
        Ranking.setPromptText("Enter your message");
        rootPane.getChildren().add(Ranking);
        
        Image image = new Image("lion.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setLayoutX(180);
        iv1.setLayoutY(180);
        iv1.setFitWidth(500);
        iv1.setPreserveRatio(true);
        rootPane.getChildren().add(iv1);
        
        Name = new TextField();
        Name.setText("Enter name");
        Name.setLayoutX(100);
        Name.setLayoutY(60);
        Name.setPrefWidth(250);
        Name.setPromptText("Enter your message");
        rootPane.getChildren().add(Name);
        
        Country = new TextField();
        Country.setText("Enter country");
        Country.setLayoutX(100);
        Country.setLayoutY(110);
        Country.setPrefWidth(250);
        Country.setPromptText("Enter your message");
        rootPane.getChildren().add(Country);

        Button btn = new Button();
        btn.setText("Click Me!");
        btn.setLayoutX(100);
        btn.setLayoutY(200);
        btn.setOnAction((ActionEvent ae) -> printMessage());
        rootPane.getChildren().add(btn);
    }

    public static void terminate()
    {
        System.out.println("bye bye");
        System.exit(0);
    }

    private static void printMessage(){
        String message1 = Ranking.getText();
        String message2 = Name.getText();
        String message3 = Country.getText();
        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message3);
    }
}