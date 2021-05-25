/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LawrZac22
 */
public class Ball {
    public float[] position, velocity;
    public boolean striped;
    public char c;
    
    private static final float FRICTION = 0.02f;
    private static final float[] SIZE = {1f, 1f};
    private static final float MASS = 0.5f;
    
    public Ball(boolean striped){
        position = new float[]{0f,0f};
        velocity = new float[]{0f,0f};
        this.striped = striped;
        c = 'O';
    }
    
    public Ball(int stiped){
        position = new float[]{0f,0f};
        (striped == 0) ? (this.striped = true) : (this.striped = false);
        velocity = new float[]{0f,0f};
        c = 'O';
    }
    
    public void update(){
        for(int i = 0; i < 2; i++){
            if(!(velocity[i] < -0.05f && velocity[i] < 0.05f)){
                position[i] += velocity[i];
                (velocity[i] > 0) ? velocity -= FRICTION : velocity += FRICTION;
            }
            else{
                velocity[i] = 0f;
            }
        }
    }
    
    public void collide(Ball other){
        
    }
    //Perfectly elastic collision and rebound from wall
    public void collideWall(boolean horiz){
        if(horiz){
            velocity[0] = -velocity[0];
            return;
        }
        velocity[1] = -velocity[1];
    }
    public boolean isTouching(Ball other){
        //Right overlapping other left
        if(position[0] + SIZE[0] > other.position[0] - SIZE[0]){
            //Top is between or lined up with the top and bottom of other
            if(position[1] + SIZE[1] >= other.position[1] - SIZE[1] && position[1] + SIZE[1] <= other.position[1] + SIZE[1]){
                return true;
            }
            //Bottom is between or lined up with the top and bottom of other
            if(position[1] - SIZE[1] >= other.position[1] - SIZE[1] && position[1] - SIZE[1] <= other.position[1] + SIZE[1]){
                return true;
            }
        }
        //Left overlapping other right
        if(position[0] - SIZE[0] < other.position[0] + SIZE[0]){
            //Top is between or lined up with the top and bottom of other
            if(position[1] + SIZE[1] >= other.position[1] - SIZE[1] && position[1] + SIZE[1] <= other.position[1] + SIZE[1]){
                return true;
            }
            //Bottom is between or lined up with the top and bottom of other
            if(position[1] - SIZE[1] >= other.position[1] - SIZE[1] && position[1] - SIZE[1] <= other.position[1] + SIZE[1]){
                return true;
            }
        }
        return false;
    }
    public void applyForce(double mag, double angle){
        double x = mag / Math.cos(angle);
        double y = mag / Math.sin(angle);
        
        velocity[0] += x;
        velocity[1] += y;
    }
}
