package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class CenterTriangle extends JPanel
{
    public java.awt.Polygon centerTriangle;
    private  SideTriangles prev;
    public List <SideTriangles> inCenterTriangle = new ArrayList<>();

    public CenterTriangle(SideTriangles t)
    {
        prev=t;
        int  x1 = (t.x3+t.x1)/2;
        int  x2 = t.x3 + ((t.x2 -  t.x3)/2);
        int  x3 = t.x3;
        int  y1 = t.y1;
        int  y2 = t.y2;
        int  y3 = ( ( y1 + t.y3) /2);
        java.awt.Polygon trojkat = new java.awt.Polygon();
        trojkat.addPoint(x1, y3);
        trojkat.addPoint(x2, y3);
        trojkat.addPoint(x3, y1);
        inCenterTriangle.add(new SideTriangles(prev.x1,x3,x1,y1,y2,y3,prev.level));
        inCenterTriangle.add(new SideTriangles(x3,prev.x2,x2,y1,y2,y3,prev.level));
        inCenterTriangle.add(new SideTriangles(x1,x2,prev.x3,y3,y3,prev.y3,prev.level));
        centerTriangle = trojkat;
    }

    public void paint(Graphics g)
    {
        super.paintComponent(g);
         g.setColor(Color.black);
        g.drawPolygon(this.centerTriangle);
        g.fillPolygon(this.centerTriangle);
    }
}
