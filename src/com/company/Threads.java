package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Threads extends JPanel implements Runnable {

    private Thread thread;
    private final int pause;
    private final SideTriangles first;
    private List<SideTriangles> sideTriangles = new ArrayList<>();
    private List<CenterTriangle> centerTriangles = new ArrayList<>();
    private int level;
    private int maxLevel;

    private void create()
    {
        List<SideTriangles> temp = new ArrayList<>();
        // RESET TRIANGLE
        if(level > maxLevel)
        {
            level=0;
            centerTriangles.clear();
            sideTriangles.clear();
            sideTriangles.add(first);
            return;
        }
        CenterTriangle center;
        for (SideTriangles kolorowe : sideTriangles) {
            center = new CenterTriangle(kolorowe);
            centerTriangles.add(center);
            temp.addAll(center.inCenterTriangle);
            if (level == 1) break;
        }
        sideTriangles.addAll(temp);
        level++;
        return;
    }


    public void paint(Graphics g)
    {
        super.paintComponent(g);

        if(!sideTriangles.isEmpty()){
        for (SideTriangles obiekt:sideTriangles)
        {
            obiekt.paint(g);
        }}
        if(!centerTriangles.isEmpty()) {
            for (CenterTriangle czarny : centerTriangles) {
                czarny.paint(g);
            }
        }
        JLabel label = new JLabel(String.valueOf(level));
        label.setSize(100,100);
        label.setFont(new Font("Verdana", Font.PLAIN, 18));
        label.paint(g);
    }

    public Threads(int X1,int X2,int X3,int Y1,int Y2,int pause,int priority,int maxHeight)
    {
        level=0;
        this.maxLevel = maxHeight;
        this.pause = pause;

        sideTriangles.add(new SideTriangles(X1,X2,X3,Y1,Y1,Y2,1));
        first = sideTriangles.get(0);
        thread=new Thread(this);
        thread.setPriority(priority);
        thread.start();
    }


    public void run()
    {
        while (true) {

            this.create();
            this.repaint();
            try
            {
                thread.sleep(pause);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

}
