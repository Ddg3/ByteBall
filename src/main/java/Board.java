/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LawrZac22
 */
public class Board {
    private static Ball[] balls;
    private static boolean quit = false;
    
    private static final int[] SIZE = {20, 15};
    private static final int[] POCKETS = {1, 8, 15};
    private static final String BOARD =  
              " ____________________"
            + "/o                  o\\"
            + "|                    |"
            + "|                    |"
            + "|                    |"
            + "|                    |"
            + "|                    |"
            + "|                    |"
            + "o                    o"
            + "|                    |"
            + "|                    |"
            + "|                    |"
            + "|                    |"
            + "|                    |"
            + "|                    |"
            + "\\o__________________o/";
    
    private static Ball[] initBalls(){
        Ball[] balls = new Ball[22];
        for(int i = 0; i < balls.length - 2; i++){
            balls[i] = new Ball(i % 2);
        }
        balls[balls.length - 2] = new EightBall();
        balls[balls.length - 1] = new CueBall();
        return balls;
    }
    
    public static void main(String[] args){
        balls = initBalls();
        while(!quit){
            update();
        }
    }
    private static void update(){
        for(int i = 0; i < balls.length; i++){
            Ball b1 = balls[i];
            //Check if touching pocket
            if((int)b1.position[0] == 0 || (int)b1.position[0] == SIZE[0] - 1){
                for(int pocket : POCKETS){
                    if((int)b1.position[1] == pocket){
                        b1.pocketed = true;
                        continue;
                    }
                }
            }
            //Check if touching other ball
            for(int j = i; j < balls.length; j++){
                Ball b2 = balls[j];
                if(b1.isTouching(b2)){
                    b1.collide(b2);
                }
            }
            //Check if touching wall
            if((int)b1.position[0] == 0 || (int)b1.position[0] == SIZE[0] - 1){
                b1.collideWall(true);
            }
            if((int)b1.position[1] == 0 || (int)b1.position[1] == SIZE[1] - 1){
                b1.collideWall(false);
            }
        }
    }
    
    private static String render(){
        String result = boardEdge() + "/n";
        //Loop through each row of the board
        for(int i = 0; i < SIZE[1] - 1; i++){
            result += horizEdge(i, true);
            String leftbound = "";
            for(Ball ball : balls){
                //Same row as board render
                if((int)ball.position[1] == i){
                    for(int j = 0; j < Math.abs(leftbound.length() - (int)(ball.position[0])); j++){
                        leftbound += " ";
                    }
                    leftbound += ball.c;
                }
            }
            for(int j = 0; j < (SIZE[0] - 1) - leftbound.length(); j++){
                leftbound += " ";
            }
            result += leftbound;
            result += horizEdge(i, false) + "/n";
        }
        result += horizEdge(14, true) + boardEdge() + horizEdge(14, false);
        return result;
    }
    
    private static String boardEdge(){
        String res = "";
        for(int i = 0; i < SIZE[0]; i++){
            res += "_";
        }
        return res;
    }
    
    private static String horizEdge(int pos, boolean left){
        if(pos == 7){
            return "o";
        }
        if(left){
            if(pos == 0){
                return "/o";
            }
            if(pos == 14){
                return "\\o";
            }
        }
        else{
            if(pos == 14){
                return "o/";
            }
            if(pos == 0){
                return "o\\";
            }
        }
        return "|";
    }
}
