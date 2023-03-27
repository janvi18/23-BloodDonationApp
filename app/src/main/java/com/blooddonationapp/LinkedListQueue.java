package com.blooddonationapp;

import android.util.Log;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.LinkedList;

class QNode {
    String userName, contactNo, bloodType, email, password;
    QNode next;

    // constructor to create a new linked list node
    public QNode(String name, String contactNo, String type, String email, String password) {
        this.userName = name;
        this.contactNo = contactNo;
        this.bloodType = type;
        this.email = email;
        this.password = password;
        this.next = null;
    }
}

class Queue {
    QNode front, rear;
    private int size;

    public Queue() {
        this.front = this.rear = null;
    }

    //Method to display()
    public static void printQueue(String name, String contactNo, String type, String email, String password) {
//        System.out.print("Queue: ");
        for (int i = 0; i < 5; i++) {
            Log.e("name:", name);
            Log.e("contactNo:", contactNo);
            Log.e("name:", name);
            Log.e("name:", name);
            Log.e("name:", name);


            //        System.out.println();
        }

    }

    public int size() {
        return size;
    }

    // Method to add an key to the queue.
    void enqueue(String name, String contactNo, String type, String email, String password) {

        // Create a new LL node
        QNode temp = new QNode(name, contactNo, type, email, password);
        Log.e("inside enqueue", name + " " + contactNo + " " + type + " " + email + " " + password);

        // If queue is empty, then new node is front and
        // rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change
        // rear
        this.rear.next = temp;
        this.rear = temp;


    }
}