# SOCOF Assignment -*Autonomous Car Interaction at Roundabouts*- Report

## Objective

This work's objective is to design and implement software for supporting interactions at roundabouts in autonomous cars. To understand what types of interaction a car can have in such type of circular intersection, your first task is to implement a simulator of that situation. This project is focused in the first task. You should implement a roundabout with multiple lanes and entrances/exits and vehicles should behave independently and concurrently, and generally respect the laws of physics and driving. The result should be a multithreaded java-based application.


## Executive Summary

The project can be divided in 4 components:
* **Roundabout** A class shared by inumerous threads (Cars) containing a List of Nodes that represent the Entrances and Exits.
* **Node** A class that represent an Exit or an Entrance of the roundabout. It contains 2 edges and a Queue of Cars (Only used in Entrance Nodes) that represents the line of Cars waiting for their turn to enter on the roundabout.
* **Edge** A class that represent a 'piece' of road connecting 2 Nodes. One Edge can only contain one Car.
* **Car** A class that extends the Thread Class, containing the logic necessary for travelling the roundabout as well as The starting node and the ending node.


Each car is a thread, so you can create as much cars as your pc can handle.

Each thread is independent and has a shared data structure that is the roundabout and it's list of nodes.

Because multiple Threads can access the same object at the same time, we assured that each shared object is atomic so that it doesn't exist data discrepancy (using AtomicBoolean and AtomicReference properties).

By assuring object atomicity we implemented a locked free aproach thus assuring and maintaining linearizability.

