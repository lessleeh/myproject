package GDT;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * GameDEV View
 *
 * @author Leslie Hoang
 */
public class ViewGameDeveloperTycoon extends Application {

    // --- Instance Variables ------------------------------------------------------------------------------------------
    private GameDeveloperTycoon gameDev;
    private Label titleLabel,fundLable;
    private GraphicsContext gc;
    private Button produceGame, hireDeveloper,hireMarketer,buildAAAStudio;

    // --- Event Handlers and Methods ----------------------------------------------------------------------------------

    // Refresh Method to refresh applicable attributes
    public void refreshButton(){
        gameDev.draw(gc);
        fundLable.setText(gameDev.getFunds());
        produceGame.setText("Develop Game("+gameDev.getDeveloperClickPower()+")");
        hireDeveloper.setText("Hire Developer(cost" +gameDev.getNumOfDevelopers()+")");
        hireMarketer.setText("Hire Marketer(cost" +gameDev.getNumOfMarketers()+")");
        buildAAAStudio.setText("Build AAA Studio(cost" +gameDev.getNumOfStudios()+")");
        setOpacity();
    }

    // Opacity Method to set opacity of button based on number of $ available
    public void setOpacity(){
        if (gameDev.getNumOfUnreleasedGames() < gameDev.getNumOfDevelopers() ){
            hireDeveloper.setOpacity(.5);
        }else {
            hireDeveloper.setOpacity(1);
        }
        if (gameDev.getNumOfUnreleasedGames() < gameDev.getNumOfMarketers() ){
            hireMarketer.setOpacity(.5);
        }else {
            hireMarketer.setOpacity(1);
        }
        if (gameDev.getNumOfUnreleasedGames() < gameDev.getNumOfStudios() ){
            buildAAAStudio.setOpacity(.5);
        }else {
            buildAAAStudio.setOpacity(1);
        }

    }

    // Produce Game button pressed
    private void produce(ActionEvent event){
        gameDev.produceClick();
        refreshButton();

    }
    // Hire Developer button pressed
    private void developer(ActionEvent event){
        gameDev.developClick();
        refreshButton();
    }
    // Hire Marketer button pressed
    private void marketer(ActionEvent event){
        gameDev.marketClick();
        refreshButton();
    }
    // Build AAA Studio button pressed
    private void studio(ActionEvent event){
        gameDev.studioClick();
        refreshButton();
    }
    // --- GUI View (Main Code) ----------------------------------------------------------------------------------------
    /**
     * GUI Components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        // --- Set window
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 225);
        stage.setTitle("FX GUI Template");
        stage.setScene(scene);

        // --- Create the model
        gameDev = new GameDeveloperTycoon();

        // --- Create the GUI components
        titleLabel = new Label("GameDeveloperTycoon");
        fundLable = new Label(gameDev.getFunds());
        produceGame = new Button("Develop Game("+gameDev.getDeveloperClickPower()+")");
        hireDeveloper = new Button("Hire Developer(cost" +gameDev.getNumOfDevelopers()+")");
        hireMarketer = new Button("Hire Marketer(cost" +gameDev.getNumOfMarketers()+")");
        buildAAAStudio = new Button("Build AAA Studio(cost" +gameDev.getNumOfStudios()+")");

        Canvas outputCanvas  = new Canvas(200,200);
        gc = outputCanvas.getGraphicsContext2D();

        // --- Add components to the root
        root.getChildren().addAll(titleLabel, produceGame,hireDeveloper,hireMarketer,buildAAAStudio,outputCanvas,fundLable);

        // --- Configure the components (colors, fonts, size, location)
        // Title
        titleLabel.relocate(10,10);
        titleLabel.setFont(new Font("courier new", 20));
        titleLabel.setStyle("-fx-background-color: gold");

        // Button Opacity
        hireDeveloper.setOpacity(.5);
        hireMarketer.setOpacity(.5);
        buildAAAStudio.setOpacity(.5);

        // Low-funds Indicator
        fundLable.relocate(220,175);
        fundLable.setFont(new Font("courier new", 15));
        fundLable.setStyle("-fx-text-fill:red; -fx-background-color: silver");

        // Buttons location
        produceGame.relocate(220,40);
        hireDeveloper.relocate(220,70);
        hireMarketer.relocate(220,100);
        buildAAAStudio.relocate(220,130);

        // Set Stage/Draw
        gameDev.draw(gc);

        // --- Event Handlers
        produceGame.setOnAction(this::produce);
        hireDeveloper.setOnAction(this::developer);
        hireMarketer.setOnAction(this::marketer);
        buildAAAStudio.setOnAction(this::studio);

        // --- Show the stage
        stage.show();
    }

    /**
     *
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
