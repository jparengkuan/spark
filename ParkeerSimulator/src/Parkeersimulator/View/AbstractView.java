package Parkeersimulator.View;

import Parkeersimulator.Model.ParkeerGarage;
import Parkeersimulator.Model.Simulator;

import javax.swing.*;

public abstract class AbstractView extends JPanel {

    protected Simulator simulator;

    public AbstractView(Simulator simulator)
    {
        this.simulator = simulator;
        simulator.addView(this);
    }

    public Simulator getModel() { return simulator; }
    public void updateView() { repaint(); }


}
