package roundabout;

public class Main {
    
    public static void main(String[] args) {
        Roundabout round = new Roundabout(2);
    
        round.PrintRoundabout();

        Car car1 = new Car(1, round, round.getNodeByIndex(2), round.getNodeByIndex(1));
        Car car2 = new Car(2, round, round.getNodeByIndex(2), round.getNodeByIndex(3));
        Car car3 = new Car(3, round, round.getNodeByIndex(2), round.getNodeByIndex(1));

        car1.start();
        car2.start();
        car3.start();

    }
}