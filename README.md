# BoardingGate

Objectives
  * More practice implementing an interface in Java
  * Exposure to the Priority Queue ADT
  * Practice implementing a Heap
  * Exposure to the Comparable<E> interface

Introduction

  This assignment has two parts:

  Part 1 
  Asks you to implement the PriorityQueue interface using an array-based Heap data
  structure that will store Comparable objects (objects that implement the Comparable interface).


  Part 2
  
  Asks you to implement a small application modeling a transportation boarding gate (i.e. an
  airport boarding gate) in which you will use your HeapPriorityQueue.
  
  For this part of the assignment, you will be creating an application to support the modelling of a
  simple boarding gate (i.e. an airplane gate) in a transit facility (i.e. an Airport). You are asked to
  write the software that will manage the boarding of passengers based on their boardingZone
  and their arrivalTime.
  Imagine… you are checking people in for their flight and assigning them a position in line.
  Passengers arrive continuously, but boarding cannot begin until the plane is ready.
  o A passenger (A) enters, they are boarding in zone 3, you add them to the queue.
  o A passenger (B) enters, they are boarding in zone 1, you add them to the queue ahead of
  the previous person.
  o Another passenger (C) enters, they are boarding in zone 1, you add them to the queue
  ahead of person A in boarding zone 1 but behind the person C in boarding zone 1 because
  they arrived at a later time.
  o The plane begins boarding, person B gets their passport checked to board
  o A passenger (D) enters, they are boarding in zone 3 2, you add them to the queue ahead
  of passenger A but behind passenger C.
