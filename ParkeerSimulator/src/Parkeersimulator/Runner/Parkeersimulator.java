package Parkeersimulator.Runner;

import Parkeersimulator.Controller.Controller;
import Parkeersimulator.Model.Simulator;
import Parkeersimulator.View.CarParkView;

import javax.swing.*;
import java.awt.*;

public class Parkeersimulator {


    private CarParkView carParkView;
    private Simulator   simulator;
    private Controller controller;
    private JFrame      screen;


    public Parkeersimulator() {

        simulator = new Simulator();

        screen = new JFrame("ParkeerSimulator");
        screen.setSize(600, 600);
        screen.setResizable(false);
        screen.setVisible(true);

        carParkView = new CarParkView(simulator);
        controller  = new Controller(simulator);


        screen.getContentPane().add(carParkView, BorderLayout.CENTER);
        screen.getContentPane().add(controller,  BorderLayout.SOUTH);
        screen.pack();
    }
}
