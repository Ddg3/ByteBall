/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOPReview;

/**
 *
 * @author LawrZac22
 */
public class Joshemon {
    private static int ID = 0;
    
    private int mID, health, damage, berries;
    public Joshemon(){
        ID++;
        mID = ID;
        health = 100;
        damage = 0;
        berries = 0;
    }
    
    public String toString(){
        String msg = "ID: " + mID + ", Health: " + health + 
                ", Total Damage Taken: " + damage + ", Total Berries Eaten: " + berries; 
        return msg;
    }
    
    public int checkHealth(){
        return health;
    }
    
    public void eatBerries(int n){
        berries += n;
        health += (2 * n);
    }
    
    public void battle(int damage_amount){
        damage += damage_amount;
        health -= damage_amount;
    }
}
