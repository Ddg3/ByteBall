/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LawrZac22
 */
public class Cue {
    public float[] position; 
    public float angle;
    public float power;
    public String symbol;
    
    private String[] orientations = {
        "|"
      + "|"
      + "|",
        
        "  /"
      + " /"
      + "/",
        
        "-----",
        
        "\\"
      + " \\"
      + "  \\"
    };
    public Cue(){
        position = new float[]{0f,0f};
        angle = 0f;
        power = 0f;
    }
    
    public void update(){
        //TOP
        if((angle > 337 && angle <= 360) || (angle > 0 && angle <= 22)){
            symbol = orientations[0];
        }
        //TOP RIGHT
        if(angle > 22 && angle <= 67 ){
            symbol = orientations[1];
        }
        //RIGHT
        if(angle > 67 && angle <= 112){
            symbol = orientations[2];
        }
        //BOTTOM RIGHT
        if(angle > 112 && angle <= 157){
            symbol = orientations[3];
        }
        //BOTTOM
        if(angle < 157 && angle <= 202){
            symbol = orientations[0];
        }
        //BOTTOM LEFT
        if(angle > 202 && angle <= 247){
            symbol = orientations[1];
        }
        //LEFT
        if(angle > 247 && angle <= 292){
            symbol = orientations[2];
        }
        //TOP LEFT
        if(angle > 292 && angle <= 337){
            symbol = orientations[3];
        }
    }
}
