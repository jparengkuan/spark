package Parkeersimulator.Controller;

import Parkeersimulator.Model.Simulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends AbstractController implements ActionListener {

    private JButton start;
    private JButton stop;

    public Controller(Simulator simulators) {
        super(simulators);

        start = new JButton("Start");
        start.addActionListener(this);
        add(start);

        stop = new JButton("Stop");
        stop.addActionListener(this);
        add(stop);

    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==start){
            simulator.run(1000);
        }

        if (e.getSource()==stop)
        {
            simulator.stop();
        }
    }
}
