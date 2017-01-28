package org.rcraft.grafodiri;

import java.util.Comparator;

/**
 * Created by rcraft on 01-27-17.
 */
public class Elemento<V,D> implements Comparable<Elemento<V,D>>
{
    private V vertice;
    private D dato;

    public Elemento(V vertice, D dato)
    {
        this.vertice = vertice;
        this.dato = dato;
    }

    public V getVertice()
    {
        return vertice;
    }

    public void setVertice(V vertice)
    {
        this.vertice = vertice;
    }

    public D getDato()
    {
        return dato;
    }

    public void setDato(D dato)
    {
        this.dato = dato;
    }

    @Override
    public int compareTo(Elemento<V, D> o)
    {
        return ((Comparable<D>)dato).compareTo(o.getDato());
    }
}
