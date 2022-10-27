import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Pair1 implements Comparator<Pair1> {
    int roll;
    String name;
    int marks;
    Pair1(int roll,String name,int marks){
        this.roll=roll;
        this.name=name;
        this.marks=marks;
    }
    Pair1(){}
    @Override
    public int compare(Pair1 p1,Pair1 p2){
        if(p1.name.compareTo(p2.name)>1){
            return 1;
        }
        else{
            return -1;
        }

    }
}

public class newPairImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pair1> list = new ArrayList<Pair1>();

        for (int i = 0; i < 3; i++) {
            int roll = sc.nextInt();
            String name = sc.next();
            int marks = sc.nextInt();

            list.add(new Pair1(roll, name, marks));
        }

        Collections.sort(list, new Pair1());
        for (Pair1 p : list) {
            System.out.println(p.roll + " " + p.name + " " + p.marks);
        }
    }
}
