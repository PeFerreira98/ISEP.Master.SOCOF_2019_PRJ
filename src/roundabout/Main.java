package roundabout;

public class Main {
    
    public static void main(String[] args) {
        Roundabout round = new Roundabout(4);
    
        round.PrintRoundabout();

        Car car1 = new Car(1, round, round.getNodeByIndex(0), round.getNodeByIndex(7));
        Car car2 = new Car(2, round, round.getNodeByIndex(2), round.getNodeByIndex(5));
        Car car3 = new Car(3, round, round.getNodeByIndex(2), round.getNodeByIndex(1));
        Car car4 = new Car(4, round, round.getNodeByIndex(2), round.getNodeByIndex(1));
        Car car5 = new Car(5, round, round.getNodeByIndex(2), round.getNodeByIndex(1));
        Car car6 = new Car(6, round, round.getNodeByIndex(4), round.getNodeByIndex(3));

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
    }
}