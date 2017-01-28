package org.rcraft.grafodiri;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Created by rcraft on 01-27-17.
 */
public class Principal
{
    public static void main(String args[])
    {
        JFrame jf=new JFrame();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Grafo<Posicion,Integer> grafo=new Grafo<Posicion,Integer>();

        grafo.insertarVertice(new Posicion("A",86,246));
        grafo.insertarVertice(new Posicion("B",362,246));
        grafo.insertarVertice(new Posicion("C",617,104));
        grafo.insertarVertice(new Posicion("D",460,381));
        grafo.insertarVertice(new Posicion("E",736,279));
        grafo.insertarVertice(new Posicion("F",634,456));
        grafo.insertarVertice(new Posicion("G",244,487));

        grafo.insertarArista(grafo.obtenerVertices().get(0),grafo.obtenerVertices().get(1),1);
        grafo.insertarArista(grafo.obtenerVertices().get(0),grafo.obtenerVertices().get(3),4);
        grafo.insertarArista(grafo.obtenerVertices().get(1),grafo.obtenerVertices().get(0),3);
        grafo.insertarArista(grafo.obtenerVertices().get(1),grafo.obtenerVertices().get(2),3);
        grafo.insertarArista(grafo.obtenerVertices().get(1),grafo.obtenerVertices().get(3),3);
        grafo.insertarArista(grafo.obtenerVertices().get(2),grafo.obtenerVertices().get(0),6);
        grafo.insertarArista(grafo.obtenerVertices().get(2),grafo.obtenerVertices().get(4),4);
        grafo.insertarArista(grafo.obtenerVertices().get(2),grafo.obtenerVertices().get(3),1);
        grafo.insertarArista(grafo.obtenerVertices().get(3),grafo.obtenerVertices().get(0),2);
        grafo.insertarArista(grafo.obtenerVertices().get(3),grafo.obtenerVertices().get(4),2);
        grafo.insertarArista(grafo.obtenerVertices().get(4),grafo.obtenerVertices().get(5),3);
        grafo.insertarArista(grafo.obtenerVertices().get(6),grafo.obtenerVertices().get(3),3);



        jf.add(new PanelGrafo(grafo));
        jf.setSize(800,600);
        jf.setVisible(true);
    }
}
