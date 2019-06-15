package roundabout;

public class Car extends Thread{
    private int id;

    private Node start;
    private Node end;
    private Edge current;

    private Roundabout roundabout;

    public Car(int id, Roundabout roundabout, Node start, Node end) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.roundabout = roundabout;
        //this.current = null;
    }

    @Override
    public synchronized void start() {
        //super.start();
        if(roundabout.hasNode(start) && roundabout.hasNode(end)){
            if(start.isIn() && end.isOut()) {
                // TODO: IF left is not busy and right is not busy
                //       THEN go!
                //      Lock your way as you go until end is reached

            } else {
                System.out.println("Can't get in at " + start + " or out at" + end);
            }
        } else {
            System.out.println("Round about does not contain " + start + " or " + end);
        }
    }
}