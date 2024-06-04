package com.code.stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JFrame implements ActionListener {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private Timer timer;
    private int elapsedTime = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;

    public Stopwatch() {
        // Set up the frame
        this.setTitle("Stopwatch");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        // Initialize label and buttons
        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        // Add action listeners to buttons
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Add components to frame
        this.add(timeLabel);
        this.add(startButton);
        this.add(stopButton);
        this.add(resetButton);

        // Initialize the timer
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elapsedTime += 1000;
                hours = (elapsedTime / 3600000);
                minutes = (elapsedTime / 60000) % 60;
                seconds = (elapsedTime / 1000) % 60;
                timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }
        });

        // Make the frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            timer.start();
        } else if (e.getSource() == stopButton) {
            timer.stop();
        } else if (e.getSource() == resetButton) {
            timer.stop();
            elapsedTime = 0;
            hours = 0;
            minutes = 0;
            seconds = 0;
            timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        }
    }

    public static void main(String[] args) {
        new Stopwatch();
    }
}
