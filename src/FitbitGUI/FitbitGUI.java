package FitbitGUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import myfitbit.Fitbit;
import org.json.JSONException;
import static javafx.application.Application.launch;

/**
 *
 * @author Yang
 */
public class FitbitGUI extends Application {

    GridPane grid = new GridPane();
    Label userName = new Label("Email");
    final TextField userTextField = new TextField();
    Label pw = new Label("StartDate");
    final TextField startdateField = new TextField();    
    Label ed = new Label("EndDate");
    final TextField edfile = new TextField();    
    Label sttime = new Label("StartTime");
    final TextField sttimeField = new TextField();    
    Label endtime = new Label("EndTime");
    final TextField endField = new TextField();
    Label period = new Label("PeriodTime");
    final TextField periodfile = new TextField();    
    @Override
    public void start(Stage primaryStage) {
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100, 100, 100, 100));

        grid.add(userName, 0, 1);
        grid.add(userTextField, 1, 1);
        
        grid.add(pw, 0, 2);
        grid.add(startdateField, 1, 2);        
        
        grid.add(ed, 0, 3);        
        grid.add(edfile, 1, 3);        
        
        grid.add(sttime, 0, 4);        
        grid.add(sttimeField, 1, 4);        
        
        grid.add(endtime, 0, 5);        
        grid.add(endField, 1, 5);
        
        grid.add(period, 0, 6);        
        grid.add(periodfile, 1, 6);  
        //-----------------------------DATE-----------------------------------

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 8);

        final Text actiontarget_5 = new Text();
        grid.add(actiontarget_5, 1,8);
 
        final Text actiontarget_1 = new Text();
        grid.add(actiontarget_1, 1, 8);
 
        final Text actiontarget_2 = new Text();
        grid.add(actiontarget_2, 1, 8);



        final Label label = new Label("Select type");
        final String[] greetings = new String[]{"HR", "SLEEP", "ACTIVITY"};
        final Label label_1 = new Label("Select ID");
        final String[] greetings_1 = new String[]{"calories", "steps", "distance","floors","elevation"};        
        final ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(" " ,"HR", "SLEEP", "ACTIVITY"));    
        final ChoiceBox cb_1 = new ChoiceBox(FXCollections.observableArrayList(" ","calories", "steps", "distance","floors","elevation"));       
        /*cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value) {
                label.setText(greetings[new_value.intValue()]);

                if (new_value.intValue() == 0 || new_value.intValue() == 2) {
                    Label sttime = new Label("StartTime");
                    Label endtime = new Label("EndTime");

                } else if (new_value.intValue() == 1) {
                    Label sttime = new Label("StartTime");
                    Label endtime = new Label("EndDate");
                }
            }
        }
        );*/

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(label,cb,label_1, cb_1);
        hbBtn.getChildren().add(btn);  

        grid.add(hbBtn, 1, 7);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                cb.getValue();
                /*
                String userNameValue = userTextField.getText();
                String passwordValue = passwordField.getText();
*/
                String starttime = sttimeField.getText();
                String edtime = endField.getText();
                String periodt = periodfile.getText();               
                String[] userNameValue=new String [3];
                userNameValue[0]= "yzufitbittest12@outlook.com";
                userNameValue[1]= "yzufitbittest10@gmail.com";
                userNameValue[2]= "YZUACCHC17@gmail.com";
                //String startdate = "2017-04-01";
                String ed = "2017-05-31";
                starttime = "00:00";
                edtime = "23:59";
                for (int x =2; x < 3; x++) {
                    for (int i = 12; i <16; i++) {
                        String startdate = "2017-08-"+i;
                        try {
                            System.out.println("1");
                            Fitbit.main(userNameValue[x], startdate, starttime, edtime, cb.getValue().toString(), cb_1.getValue().toString(), ed, periodt);
                        } catch (JSONException ex) {
                            System.out.println("2");
                            Logger.getLogger(FitbitGUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            System.out.println("3");
                            Logger.getLogger(FitbitGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                String result = "Weclome";

                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText(result);

                actiontarget_1.setFill(Color.FIREBRICK);
                actiontarget_1.setText(result);

                actiontarget_2.setFill(Color.FIREBRICK);
                actiontarget_2.setText(result);

            }
        });
        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        Text scentitle = new Text("Welcome");

        scentitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scentitle, 0, 0, 2, 1);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
