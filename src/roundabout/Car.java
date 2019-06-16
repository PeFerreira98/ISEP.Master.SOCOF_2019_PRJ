package roundabout;

import java.util.Random;

public class Car extends Thread {
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
        // this.current = null;
    }

    @Override
    public void run() {
        // super.start();
        if (roundabout.hasNode(start) && roundabout.hasNode(end)) {
            if (start.isIn() && end.isOut()) {
                Node actual = this.start;
                actual.addCar(this);

                while (true) {
                    // if (actual.getId() == start.getId()) {
                    //     while (this.roundabout.getNode(actual).getPrevious().isBusy()
                    //             || this.roundabout.getNode(actual).hasCar()
                    //             || this.roundabout.getNode(actual).getPrevious().getStart().getPrevious().isBusy()) {
                    //         System.out.println("Car " + this.id + " is wating on " + actual.getId());
                    //     }
                    // }
                    while (this.roundabout.getNode(actual).getNext().isBusy()) {
                    }

                    //Check if vehicle is wating to enter on roundabout and if is his turn
                    if(actual.getId() == start.getId()){
                        if(actual.checkCar(this)){
                            actual.removeCar();
                        }else{
                            System.out.println("Car " + this.id + " is on hold on entrance " + start.getId());
                            continue;
                        }
                    }

                    this.roundabout.getNode(actual).getNext().setBusy(true);
                    // this.roundabout.getNode(actual).setHasCar(false);

                    //Random time to simulate the speed travel
                    try {
                        sleep(new Random().nextInt(3500 - 1000) + 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    this.roundabout.getNode(actual).getPrevious().setBusy(false);
                    actual = this.roundabout.getNode(actual).getNext().getEnd();
                    // this.roundabout.getNode(actual).setHasCar(true);

                    System.out.println("Car " + this.id + " has moved to " + actual.getId());

                    if(actual.getId() == end.getId()){
                        this.roundabout.getNode(actual).getPrevious().setBusy(false);
                        // this.roundabout.getNode(actual).setHasCar(false);
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