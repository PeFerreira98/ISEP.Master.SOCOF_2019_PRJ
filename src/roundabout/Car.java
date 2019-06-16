package roundabout;

import java.util.Random;

public class Car extends Thread {
    private final int id;

    private final Node start;
    private final Node end;
    private final Roundabout roundabout;

    public Car(int id, Roundabout roundabout, Node start, Node end) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.roundabout = roundabout;
    }

    @Override
    public void run() {
        // super.start();
        if(start != null && end != null && roundabout != null) {
            if (roundabout.hasNode(start) && roundabout.hasNode(end)) {
                if (start.isIn() && end.isOut()) {

                    Node actualNode = this.start;
                    Edge currentEdge = this.start.getNext();
                    actualNode.addCar(this);

                    while (true) {

                        //Check if vehicle is wating to enter on roundabout and if is his turn
                        if (actualNode == start) {
                            if (actualNode.checkCar(this)) {
                                actualNode.removeCar();
                            } else {
                                System.out.println("Car " + this.id + " is on hold on entrance " + start.getId());
                                //this.wait();
                                continue;
                            }
                        }

                        // loop until right and left is empty
                        while (true) {
                            if (currentEdge.acquire()) {
                                if (actualNode.getPrevious().acquire()) {
                                    actualNode.getPrevious().release();
                                    break;
                                } else {
                                    currentEdge.release();
                                }
                            }
                            //this.wait();
                        }

                        //Random time to simulate the travel time
                        try {
                            sleep(new Random().nextInt(3500 - 1000) + 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        currentEdge.release();

                        actualNode = actualNode.getNext().getEnd();
                        currentEdge = currentEdge.getEnd().getNext();

                        System.out.println("Car " + this.id + " has moved to " + actualNode.getId());

                        if (actualNode == end) {
                            actualNode.getPrevious().release();
                            System.out.println("Car " + this.id + " has arrived to his destiny.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Can't get in at " + start + " or out at " + end);
                }
            } else {
                System.out.println("Round about does not contain " + start + " or " + end);
            }
        }
    }
}