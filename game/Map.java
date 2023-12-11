package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Map {
    int start;
    int end;
    double val;

    public Map(int start, int end, double val) {
        this.start = start;
        this.end = end;
        this.val = val;
    }

    public static List<Map> dodgeChance() {
        List<Map> mapList = new ArrayList<>();
        mapList.add(new Map(18, 20, 0.35));
        mapList.add(new Map(15, 18, 0.3));
        mapList.add(new Map(10, 15, 0.25));
        mapList.add(new Map(0, 10, 0.2));
        return mapList;
    }

    public static List<Map> healthModifier() {
        Random rand = new Random();
        List<Map> mapList1 = new ArrayList<>();
        mapList1.add(new Map(18, 20, rand.nextInt(20, 30) / 100.0));
        mapList1.add(new Map(16, 17, rand.nextInt(20, 25) / 100.0));
        mapList1.add(new Map(11, 15, rand.nextInt(15, 20) / 100.0));
        mapList1.add(new Map(5, 11, rand.nextInt(10, 15) / 100.0));
        mapList1.add(new Map(1, 4, rand.nextInt(4, 10) / 100.0));
        mapList1.add(new Map(0, 0, 0.0));
        return mapList1;
    }

    public static List<Map> strengthModifer(){
        Random rand = new Random();
        List<Map> mapList1 = new ArrayList<>();
        mapList1.add(new Map(18, 20, rand.nextInt(3,9)));
        mapList1.add(new Map(16, 17, rand.nextInt(3,6)));
        mapList1.add(new Map(14, 15, rand.nextInt(1,4)));
        mapList1.add(new Map(12, 13, rand.nextInt(1,3)));
        mapList1.add(new Map(0, 11, rand.nextInt(-1,1)));
        return mapList1;

    }

    public boolean contains(int value) {
        return value >= start && value <= end;
    }
}
