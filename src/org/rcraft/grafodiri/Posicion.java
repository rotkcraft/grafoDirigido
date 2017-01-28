package org.rcraft.grafodiri;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 * Created by rcraft on 01-27-17.
 */
public class Posicion implements Comparable<Posicion>
{
    private String dato;
    private int x;
    private int y;
    private int radio;

    public Posicion(String dato, int x, int y)
    {
        this.dato = dato;
        this.x = x;
        this.y = y;
        this.radio=20;
    }

    public String getDato()
    {
        return dato;
    }

    public void setDato(String dato)
    {
        this.dato = dato;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public int compareTo(Posicion o)
    {
        return this.getDato().compareToIgnoreCase(o.getDato());
    }
    public String toString()
    {
        return this.getDato();
    }

    public boolean detectar(Point punto)
    {
        return new Area(new Ellipse2D.Double(getX()-radio,getY()-radio,
                radio*2,radio*2)).contains(punto);
    }

    public void dibujar(Graphics graphics)
    {
        Graphics2D g=(Graphics2D)graphics;
        g.setColor(Color.DARK_GRAY);
        g.fillOval(getX()-radio,getY()-radio,
                radio*2,radio*2);
        g.setColor(Color.BLACK);
        g.drawOval(getX()-radio,getY()-radio,
                radio*2,radio*2);
        g.drawString(getDato(),getX()-3,getY()+2);


    }





}
