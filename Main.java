
/* Code for Assignment ?? 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.*;

/** <description of class Main>
 */
public class Main{

    private Arm arm;
    private Drawing drawing;
    private ToolPath tool_path = new ToolPath();
    // state of the GUI
    private int state; // 0 - nothing
    // 1 - inverse point kinematics - point
    // 2 - enter path. Each click adds point  
    // 3 - enter path pause. Click does not add the point to the path
    private int[] xaxis = new int[4];
    private int[] yaxis = new int[4];
    boolean penDown = true;
    /**      */
    public Main(){
        UI.initialise();
        UI.addButton("xy to angles", this::inverse);
        UI.addButton("Enter path XY", this::enter_path_xy);
        UI.addButton("Save path XY", this::save_xy);
        UI.addButton("Load path XY", this::load_xy);
        UI.addButton("Save path Ang", this::save_ang);
        UI.addButton("Draw Rect", this::drawRect);
        UI.addButton("Draw Circle", this::drawCircle);
        UI.addButton("Draw Skynet", this::drawS);
        UI.addButton("Draw SnowMan", this::drawSnowMan);
        UI.addButton("Load path Ang:Play", this::load_ang);
        UI.addButton("Save",this::save);
        // UI.addButton("Quit", UI::quit);
        UI.setMouseMotionListener(this::doMouse);
        UI.setKeyListener(this::doKeys);

        //ServerSocket serverSocket = new ServerSocket(22); 
        this.arm = new Arm();
        this.drawing = new Drawing();
        this.run();
        arm.draw();

    }

    public void drawCircle(){
        double theta = 0;  // angle that will be increased each loop
        double h = 329;      // x coordinate of circle center
        double k = 145;      // y coordinate of circle center
        double step = 15;  // amount to add to theta each time (degrees)
        double x,y;
        double r = 25;
        while(theta <= 360)
        {
            x = h + r*Math.cos(Math.toRadians(theta));
            y = k + r*Math.sin(Math.toRadians(theta));
            drawing.add_point_to_path(x,y,true);
            theta+=step;

        }
        this.save_ang();
    }

    public void drawSnowMan(){
        drawing.add_point_to_path(346,75,true);
        drawing.add_point_to_path(328,81,true);
        //drawing.add_point_to_path(312,106,true);
        drawing.add_point_to_path(321,99,true);
        drawing.add_point_to_path(324,116,true);
        drawing.add_point_to_path(334,124,true);
        drawing.add_point_to_path(318,138,true);
        drawing.add_point_to_path(309,157,true);
        drawing.add_point_to_path(318,182,true);
        drawing.add_point_to_path(346,193,true);
        //drawing.add_point_to_path(312,106,true);
        drawing.add_point_to_path(374,177,true);
        drawing.add_point_to_path(379,160,true);
        drawing.add_point_to_path(371,139,true);

        drawing.add_point_to_path(357,124,true);
        drawing.add_point_to_path(366,113,true);
        drawing.add_point_to_path(367,107,true);
        drawing.add_point_to_path(370,97,true);
        //drawing.add_point_to_path(312,106,true);
        drawing.add_point_to_path(360,83,true);
        drawing.add_point_to_path(346,75,true);
        drawing.add_point_to_path(328,81,true);
        this.penDown=false;
        drawing.add_point_to_path(335,95,false);
        this.penDown=true;
        drawing.add_point_to_path(335,95,true);
        this.penDown=false;
        drawing.add_point_to_path(354,95,false);
        this.penDown=true;
        drawing.add_point_to_path(354,95,true);
        this.penDown=false;
        drawing.add_point_to_path(333,106,false);
        this.penDown=true;
        drawing.add_point_to_path(333,106,true);
        drawing.add_point_to_path(337,109,true);
        drawing.add_point_to_path(345,113,true);
        drawing.add_point_to_path(347,114,true);
        drawing.add_point_to_path(353,112,true);
        drawing.add_point_to_path(356,108,true);
        drawing.add_point_to_path(355,106,true);
        this.penDown=false;
        drawing.add_point_to_path(318,141,false);
        this.penDown=true;
        drawing.add_point_to_path(318,141,true);
        drawing.add_point_to_path(308,131,true);
        this.penDown=false;
        drawing.add_point_to_path(369,141,false);
        this.penDown=true;
        drawing.add_point_to_path(369,141,true);
        drawing.add_point_to_path(379,131,true);
        drawing.add_point_to_path(391,130,true);
        this.penDown=false;
        drawing.add_point_to_path(379,131,false); 
        this.penDown=true;
        drawing.add_point_to_path(379,131,true); 
        drawing.add_point_to_path(382,120,true);
        this.penDown=false;
        drawing.add_point_to_path(308,131,false);
        this.penDown=true;
        drawing.add_point_to_path(308,131,true);
        drawing.add_point_to_path(305,121,true);
        this.penDown=false;
        drawing.add_point_to_path(308,131,false);
        this.penDown=true;
        drawing.add_point_to_path(308,131,true);
        drawing.add_point_to_path(299,138,true);
        this.penDown=false;
        drawing.add_point_to_path(345,142,false);
        this.penDown=true;
        drawing.add_point_to_path(345,142,true);
        this.penDown=false;
        drawing.add_point_to_path(345,158,false);
        this.penDown=true;
        drawing.add_point_to_path(345,158,true);
        this.penDown=false;
        drawing.add_point_to_path(345,179,false);
        this.penDown=true;
        drawing.add_point_to_path(345,179,true);
        this.penDown=false;
        drawing.add_point_to_path(341,70,false);
        this.penDown=true;
        drawing.add_point_to_path(341,70,true);
        this.penDown=false;
        drawing.add_point_to_path(341,70,false);
        this.penDown=true;
        drawing.add_point_to_path(341,70,true);
        drawing.add_point_to_path(369,86,true);
        this.penDown=false;
        drawing.add_point_to_path(351,74,false);
        this.penDown=true;
        drawing.add_point_to_path(351,74,true);
        drawing.add_point_to_path(354,70,true);
        drawing.add_point_to_path(363,76,true);
        drawing.add_point_to_path(362,80,true);

        this.save_ang();
    }

    public void drawS(){
        this.penDown=true;
        drawing.add_point_to_path(284,107,true);
        drawing.add_point_to_path(254,107,true);
        //drawing.add_point_to_path(312,106,true);
        drawing.add_point_to_path(254,117,true);
        drawing.add_point_to_path(284,117,true);
        drawing.add_point_to_path(284,127,true);
        drawing.add_point_to_path(254,127,true);
        this.penDown=false;
        drawing.add_point_to_path(294,107,false);
        this.penDown=true;
        drawing.add_point_to_path(294,107,true);
        drawing.add_point_to_path(294,127,true);
        this.penDown=false;
        drawing.add_point_to_path(314,107,false);
        this.penDown=true;
        drawing.add_point_to_path(314,107,true);
        drawing.add_point_to_path(294,117,true);
        drawing.add_point_to_path(314,127,true);
        //points for drawing k end
        this.penDown=false;
        //drawing.path_raise_pen();
        drawing.add_point_to_path(324,107,false);
        this.penDown=true;
        drawing.add_point_to_path(324,107,true);
        drawing.add_point_to_path(330,120,true);
        //drawing.path_raise_pen();
        this.penDown=false;
        drawing.add_point_to_path(332,107,false);
        this.penDown=true;
        drawing.add_point_to_path(332,107,true);
        drawing.add_point_to_path(324,127,true);
        //points for drawing y end
        this.penDown=false;
        drawing.add_point_to_path(338,127,false);
        this.penDown=true;
        drawing.add_point_to_path(338,127,true);
        drawing.add_point_to_path(338,107,true);
        drawing.add_point_to_path(349,127,true);
        drawing.add_point_to_path(349,107,true);
        //points for drawing N end
        this.penDown=false;
        drawing.add_point_to_path(359,107,false);
        this.penDown=true;
        drawing.add_point_to_path(359,107,true);
        drawing.add_point_to_path(359,127,true);
        this.penDown=false;
        drawing.add_point_to_path(359,107,false);
        this.penDown=true;
        drawing.add_point_to_path(359,107,true);
        drawing.add_point_to_path(365,107,true);
        this.penDown=false;
        drawing.add_point_to_path(359,117,false);
        this.penDown=true;
        drawing.add_point_to_path(359,117,true);
        drawing.add_point_to_path(365,117,true);
        this.penDown=false;
        drawing.add_point_to_path(359,127,false);
        this.penDown=true;
        drawing.add_point_to_path(359,127,true);
        drawing.add_point_to_path(365,127,true);
        //points for drawing E end
        this.penDown=false;
        drawing.add_point_to_path(375,107,false);
        this.penDown=true;
        drawing.add_point_to_path(375,107,true);
        drawing.add_point_to_path(382,107,true);
        this.penDown=false;
        drawing.add_point_to_path(378,107,false);
        this.penDown=true;
        drawing.add_point_to_path(378,107,true);
        drawing.add_point_to_path(378,127,true);
        //points for drawing T end
        this.save_ang();
    }

    public void drawRect(){
        drawing.add_point_to_path(312,96,true);
        drawing.add_point_to_path(362,96,true);
        drawing.add_point_to_path(362,146,true);
        drawing.add_point_to_path(312,146,true);
        drawing.add_point_to_path(312,96,true);
        this.save_ang();
    }

    public void doKeys(String action){
        UI.printf("Key :%s \n", action);
        if (action.equals("b")) {
            // break - stop entering the lines
            state = 3;
            //

        }

    }

    public void doMouse(String action, double x, double y) {
        //UI.printf("Mouse Click:%s, state:%d  x:%3.1f  y:%3.1f\n",
        //   action,state,x,y);
        UI.clearGraphics();
        String out_str=String.format("%3.1f %3.1f",x,y);
        UI.drawString(out_str, x+10,y+10);
        // 
        if ((state == 1)&&(action.equals("clicked"))){
            // draw as 

            arm.inverseKinematic(x,y);
            arm.draw();
            return;
        }

        if ( ((state == 2)||(state == 3))&&action.equals("moved") ){
            // draw arm and path
            arm.inverseKinematic(x,y);
            arm.draw();

            // draw segment from last entered point to current mouse position
            if ((state == 2)&&(drawing.get_path_size()>0)){
                PointXY lp = new PointXY();
                lp = drawing.get_path_last_point();
                //if (lp.get_pen()){
                UI.setColor(Color.GRAY);
                UI.drawLine(lp.get_x(),lp.get_y(),x,y);
                // }
            }
            drawing.draw();
        }

        // add point
        if (   (state == 2) &&(action.equals("clicked"))){
            // add point(pen down) and draw
            UI.printf("Adding point x=%f y=%f\n",x,y);
            drawing.add_point_to_path(x,y,true); // add point with pen down

            arm.inverseKinematic(x,y);
            arm.draw();
            drawing.draw();
            drawing.print_path();
        }

        if (   (state == 3) &&(action.equals("clicked"))){
            // add point and draw
            //UI.printf("Adding point x=%f y=%f\n",x,y);
            drawing.add_point_to_path(x,y,false); // add point wit pen up

            arm.inverseKinematic(x,y);
            arm.draw();
            drawing.draw();
            drawing.print_path();
            state = 2;
        }

    }

    public void save_xy(){
        state = 0;
        String fname = UIFileChooser.save();
        drawing.save_path(fname);
    }

    public void enter_path_xy(){
        state = 2;
    }

    public void inverse(){
        state = 1;
        arm.draw();
    }

    public void load_xy(){
        state = 0;
        String fname = UIFileChooser.open();
        drawing.load_path(fname);
        drawing.draw();

        arm.draw();
    }

    // save angles into the file
    public void save_ang(){
        String fname = UIFileChooser.open();
        tool_path.convert_drawing_to_angles(drawing,arm,fname);
        tool_path.save_angles(fname);
    }

    public void save(){
        String fname = "test";
        tool_path.convert_drawing_to_angles(drawing,arm,fname);
        tool_path.save_angles(fname);
        try {
            Runtime.getRuntime().exec("pscp -l pi -pw pi test pi@10.140.194.193:/home/pi/Arm");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load_ang(){

    }

    public void run() {
        while(true) {
            arm.draw();
            UI.sleep(20);
        }
    }

    public static void main(String[] args){
        Main obj = new Main();
    }    

}
