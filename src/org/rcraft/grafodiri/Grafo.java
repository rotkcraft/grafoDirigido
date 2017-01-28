package org.rcraft.grafodiri;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by rcraft on 01-27-17.
 */
public class Grafo<V,D>
{
    private LinkedHashMap<V,LinkedList<Elemento<V,D>>> g;
    public Grafo()
    {
        g=new LinkedHashMap<V, LinkedList<Elemento<V, D>>>();
    }

    public void insertarVertice(V vertice)
    {
        if(!g.containsKey(vertice))
        {
            g.put(vertice,new LinkedList<Elemento<V, D>>());
        }
    }

    public void insertarArista(V verticeA, V verticeB,D valor)
    {
        if(g.containsKey(verticeA) && g.containsKey(verticeB)
                && !existeArista(g.get(verticeA),verticeB))
        {
             g.get(verticeA).add(new Elemento<V, D>(verticeB,valor));
        }
    }

    private boolean existeArista(LinkedList<Elemento<V, D>> elementos, V verticeB)
    {
        for(Elemento<V,D> elm:elementos)
        {
            if(elm.getVertice().equals(verticeB))
            {
                return true;
            }
        }
        return false;
    }

    public boolean existeArista(V a ,V v)
    {
        return existeArista(g.get(a),v);
    }

    public int cantVeces(V verticeC)
    {
        int c=0;

        for(V vertice:obtenerVertices())
        {
            for(Elemento<V,D> elemento:this.obtenerAristas(vertice))
            {
                if(elemento.getVertice().equals(verticeC))
                {
                    c++;
                }
            }
        }

        return c;
    }

    public ArrayList<V> obtenerVertices()
    {
        return new ArrayList<V>(g.keySet());
    }

    public LinkedList<Elemento<V,D>> obtenerAristas(V vertice)
    {
        return g.get(vertice);
    }

















}
