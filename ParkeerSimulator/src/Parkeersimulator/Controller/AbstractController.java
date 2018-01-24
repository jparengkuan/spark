package Parkeersimulator.Controller;

import Parkeersimulator.Model.Simulator;

import javax.swing.*;

public abstract class AbstractController extends JPanel {
    protected Simulator simulator;

    public AbstractController(Simulator simulator) {
        this.simulator = simulator;
    }
}
