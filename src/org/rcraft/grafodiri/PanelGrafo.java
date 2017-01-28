package org.rcraft.grafodiri;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

/**
 * Created by rcraft on 01-27-17.
 */
public class PanelGrafo extends JPanel
{
    Grafo<Posicion,Integer> posicionIntegerGrafo;

    public PanelGrafo(Grafo<Posicion, Integer> posicionIntegerGrafo)
    {
        super();
        this.setFocusable(true);
        this.posicionIntegerGrafo = posicionIntegerGrafo;


    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Posicion vertice:posicionIntegerGrafo.obtenerVertices())
        {

            for(Elemento<Posicion,Integer> arista:posicionIntegerGrafo.obtenerAristas(vertice))
            {
                int x2=arista.getVertice().getX();
                int y2=arista.getVertice().getY();
                int x1=vertice.getX();
                int y1=vertice.getY();
                if(posicionIntegerGrafo.existeArista(arista.getVertice(),vertice))
                {
                      dibujarLinea(g,x1-5,y1-5,x2-5,y2-5,arista.getDato(),5);
                }
                else
                {
                    dibujarLinea(g,x1,y1,x2,y2,arista.getDato(),0);
                }

            }
            vertice.dibujar(g);
        }

    }

    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2, Integer peso, int i)
    {
        Graphics2D g2=(Graphics2D)g.create();
        double dx=x2-x1,dy=y2-y1;
        double angulo=Math.atan2(dy,dx);
        int distancia=-20+i+(int)Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        Line2D linea=new Line2D.Double(20+i,0,distancia,0);

        AffineTransform affineTransform=AffineTransform.getTranslateInstance(x1,y1);
        affineTransform.concatenate(AffineTransform.getRotateInstance(angulo));
        g2.transform(affineTransform);

        g2.drawString(String.valueOf(peso),(int)linea.getBounds().getCenterX(),
                (int)linea.getBounds().getCenterY());

        g2.draw(linea);

        int c=4;

        Polygon polygon=new Polygon();
        polygon.addPoint(distancia,0);
        polygon.addPoint(distancia-c,-c);
        polygon.addPoint(distancia-c,c);
        g2.setColor(Color.BLUE);
        g2.fillPolygon(polygon);
    }
}
