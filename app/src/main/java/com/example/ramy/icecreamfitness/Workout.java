package com.example.ramy.icecreamfitness;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ramy on 2017-05-01.
 */

public class Workout {
    private Date date;
    private String Type;
    private ArrayList<String> exerciseA = new ArrayList<>();
    private ArrayList<String> exerciseB = new ArrayList<>();
    private ArrayList<Integer> setA = new ArrayList<>();
    private ArrayList<Integer> setB = new ArrayList<>();
    private ArrayList<Integer> repA = new ArrayList<>();
    private ArrayList<Integer> repB = new ArrayList<>();

    public Workout(){
        exerciseA.add("Squats");
        exerciseA.add("Bench Press");
        exerciseA.add("Bent Over Row");
        exerciseA.add("Barbell Shrugs");
        exerciseA.add("Tricep Extensions");
        exerciseA.add("Straight Bar or Incline Curls");
        exerciseA.add("Hyperextensions with plate");
        exerciseA.add("Cable Crunches");

        setA.add(5);
        setA.add(5);
        setA.add(5);
        setA.add(3);
        setA.add(3);
        setA.add(3);
        setA.add(2);
        setA.add(3);

        repA.add(5);
        repA.add(5);
        repA.add(5);
        repA.add(8);
        repA.add(8);
        repA.add(8);
        repA.add(10);
        repA.add(10);



        exerciseB.add("Squats");
        exerciseB.add("Deadlift");
        exerciseB.add("Standing Press");
        exerciseB.add("Bent Over Row 10%LESS");
        exerciseB.add("Close Grip Bench Press");
        exerciseB.add("Straight Bar or Incline Curls");
        exerciseB.add("Cable Crunches");

        setB.add(5);
        setB.add(1);
        setB.add(5);
        setB.add(5);
        setB.add(3);
        setB.add(3);
        setB.add(3);

        repB.add(5);
        repB.add(5);
        repB.add(5);
        repB.add(5);
        repB.add(8);
        repB.add(8);
        repB.add(10);



    }

}
