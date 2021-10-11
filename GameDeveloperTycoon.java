package GDT;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *GameDEV
 *
 * @author Leslie Hoang
 */

public class GameDeveloperTycoon {
    // --- Instant Variables -------------------------------------------------------------------------------------------
    private int developerClickPower=1,numOfStudios=0, numOfMarketers=0, numOfDevelopers=0, numOfUnreleasedGames=0;
    public static final String money = "$";
    private String funds = "";

    // --- Getters -----------------------------------------------------------------------------------------------------

    /**
     * helps update opacity of button
     *
     * @return num of $ available
     */
    public int getNumOfUnreleasedGames() {
        return numOfUnreleasedGames;
    }

    /**
     * helps update button
     *
     * @return num of clicking power
     */
    public int getDeveloperClickPower() {
        return developerClickPower;
    }
    /**
     * helps update button
     *
     * @return num of developers
     */
    public int getNumOfDevelopers() {
        return (10+(10*numOfDevelopers));
    }
    /**
     * helps update button
     *
     * @return num of marketers
     */
    public int getNumOfMarketers() {
        return (100+(100*numOfMarketers));
    }
    /**
     * helps update button
     *
     * @return num of studios
     */
    public int getNumOfStudios() {
        return (1000+(1000*numOfStudios));
    }

    /**
     * indicates if enough funds are available
     *
     * @return the fund message
     */
    public String getFunds() {
        return funds;
    }

    // --- Drawing -----------------------------------------------------------------------------------------------------
    /**
     * Draws the canvas and information
     *
     * @param gc GraphicContext
     */
    public void draw(GraphicsContext gc){
        gc.setFill(Color.TAN);
        gc.fillRect(10,40,200,200);

        gc.setFill(Color.BLACK);
        gc.fillText(" Developers: "+numOfDevelopers,10,55);

        gc.fillText(" Marketers: "+ numOfMarketers,10,70);

        gc.fillText(" Studios: "+numOfStudios, 10, 85);

        gc.fillText(" Unrealeased Games: "+numOfUnreleasedGames, 10, 100);

        String repeated = money.repeat(numOfUnreleasedGames/10);
        if (repeated.length()>27){
            repeated = "$$$$$$$$$$$$$$$$$$$$$$$$$$$...";
            gc.fillText(" "+repeated,10,115);
            gc.fillText(" (╯°□°）╯︵ ┻━┻MUCH MONEY", 10,130);
        }else {
            gc.fillText(" " + repeated, 10, 115);
        }


    }

    // --- Methods buttons calls ---------------------------------------------------------------------------------------
    /**
     * increases the num of unreleased games
     */
    public void produceClick(){
        funds="";
        numOfUnreleasedGames +=developerClickPower;
    }

    /**
     * increase developer
     */
    public void developClick(){
        if (numOfUnreleasedGames >=10+(10*numOfDevelopers)){
            funds="";
            numOfUnreleasedGames -=10+(10*numOfDevelopers);
            numOfDevelopers +=1;
            developerClickPower+=5;
        } else {
            funds="Insufficient Funds";
        }
    }

    /**
     * increase marketers
     */
    public void marketClick(){
        if (numOfUnreleasedGames >=100+(100*numOfMarketers)){
            funds="";
            numOfUnreleasedGames -=100+(100*numOfMarketers);
            numOfMarketers +=1;
            developerClickPower+=20;
        } else {
            funds="Insufficient Funds";
        }
    }

    /**
     * increase studios
     */
    public void studioClick(){
        if (numOfUnreleasedGames >=1000+(1000*numOfStudios)){
            funds="";
            numOfUnreleasedGames -=1000+(1000*numOfStudios);
            numOfStudios +=1;
            developerClickPower+=100;
        } else {
            funds="Insufficient Funds";
        }
    }

}
