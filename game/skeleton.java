package game;

import java.util.Random;

class Skeleton extends Enemy{
    public Skeleton() {
        this.name = "Skeleton";
        this.health = genEHealth();
        this.dodge = genEDodge();
        this.alive = true;
    }


    @Override
    public double getDmg(){
        return 22;
    }

    public int genEHealth(){
        Random rand = new Random();
        return  rand.nextInt(100,110);
    }

    public int genEDodge(){
        Random rand = new Random();
        return  rand.nextInt(4,6);

    }



}
