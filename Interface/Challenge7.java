import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;

public class Challenge7
{
    private static TextField txtFieldRanking;
    private static TextField txtFieldName;
    private static TextField txtFieldCountry;
    private static ListView<University> uniListView;
    private static ArrayList<University> uniArrList = new ArrayList<University>();
    private static University currentlySelectedUniversity = null;

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
        stage.setTitle("Top Universities");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth (1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show();

        uniListView = new ListView<University>();
        uniListView.setLayoutX(700);
        uniListView.setLayoutY(50);
        uniListView.setOnMouseClicked((MouseEvent me) -> {
                currentlySelectedUniversity = uniListView.getSelectionModel().getSelectedItem();
            });
        rootPane.getChildren().add(uniListView);
        updateListView();

        Label label = new Label("Enter details of top university");
        label.setLayoutX(50);
        label.setLayoutY(50);
        rootPane.getChildren().add(label);

        txtFieldRanking = new TextField();
        txtFieldRanking.setLayoutX(50);
        txtFieldRanking.setLayoutY(100);
        txtFieldRanking.setPrefWidth(400);
        txtFieldRanking.setPromptText("Enter ranking");
        rootPane.getChildren().add(txtFieldRanking);

        txtFieldName = new TextField();
        txtFieldName.setLayoutX(50);
        txtFieldName.setLayoutY(150);
        txtFieldName.setPrefWidth(400);
        txtFieldName.setPromptText("Enter name");
        rootPane.getChildren().add(txtFieldName);

        txtFieldCountry = new TextField();
        txtFieldCountry.setLayoutX(50);
        txtFieldCountry.setLayoutY(200);
        txtFieldCountry.setPrefWidth(400);
        txtFieldCountry.setPromptText("Enter name");
        rootPane.getChildren().add(txtFieldCountry);

        Button btn = new Button();
        btn.setText("try me!");
        btn.setLayoutX(512);
        btn.setLayoutY(384);
        btn.setOnAction((ActionEvent ae) -> addNewItem());
        rootPane.getChildren().
        add(btn);
        
        Button rid = new Button();
        rid.setText("Deleted");
        rid.setLayoutX(612);
        rid.setLayoutY(484);
        rid.setOnAction((ActionEvent ae) -> deleteItem());
        rootPane.getChildren().
        add(rid);
    }
    
    private static void addNewItem() {
        int ranking = Integer.parseInt(txtFieldRanking.getText());
        String name = txtFieldName.getText();
        String country = txtFieldCountry.getText();
        uniArrList.add(new University(ranking, name, country));
    }
    
    private static void updateListView () {
        uniListView.getItems().clear();

        for (University uni : uniArrList){
            uniListView.getItems().add(uni);
        }
    }
    
    private static void terminate()
    {
        System.out.println("bye bye!");
        System.exit(0);
    }
    
    private static void deleteItem(){
        uniArrList.remove(currentlySelectedUniversity);
        updateListView();
    }
}
