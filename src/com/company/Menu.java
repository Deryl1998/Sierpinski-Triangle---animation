package com.company;

import javax.swing.*;
import java.awt.*;



public class Menu extends JFrame
{

    public Menu()
    {
        super("Window");

        int x1 = 30 , lenght=350, topY = 30 ,basisY = 340;
        int window_widh = 1920 , window_height=1200 ;
        int pause = 900;
        int maxHeight = 5;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        setLocation(0,0);
        setSize(window_widh, window_height);

       Container container = getContentPane();
        GridLayout grid = new GridLayout(2,5);
        container.setLayout(grid);
       int a = x1, b = lenght+x1 , c= (x1+lenght+x1)/2;

       for(int i=0;i<10;i++)
       {
           String priority =JOptionPane.showInputDialog(null,"Input priority for triangle 1-10 , triangle number - "+(i+1));
           if(priority.isEmpty()) priority="10";
           container.add( new Threads(a,b,c,basisY,topY,pause,Integer.parseInt(priority),maxHeight));
       }

        setVisible(true);

    }
}
