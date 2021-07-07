package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ConcurrentModificationException;
import java.util.Random;

public class SideTriangles extends JPanel{

    public java.awt.Polygon triangle;
    int x1;
    int x2;
    int x3;
    int y1;
    int y2;
    int y3;
    int level;
    private Color colorTab[]={Color.YELLOW,Color.pink,Color.red,Color.orange};
    private  Random rand = new Random();
    public SideTriangles(int X1,int X2,int X3,int Y1,int Y2,int Y3,int p)
    {
        level=p*2;
        this.x1=X1;
        this.x2=X2;
        this.x3=X3;
        this.y1=Y1;
        this.y2=Y2;
        this.y3=Y3;
        java.awt.Polygon trojkat = new java.awt.Polygon();
        trojkat.addPoint(x1, y1);
        trojkat.addPoint(x2, y2);
        trojkat.addPoint(x3, y3);
        triangle = trojkat;
    }

    public void paint(Graphics g)
    {
        super.paintComponent(g);
        int i=rand.nextInt(3);
        g.setColor(colorTab[i]);
        g.drawPolygon(this.triangle);
        g.fillPolygon(this.triangle);
    }


}
