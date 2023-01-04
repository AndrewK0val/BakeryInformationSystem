package com.example.bakeryinformationsystem.ADT;

public class LinkedNode<E> {
    public LinkedNode<E> head=null; //it starts as null as there is no node until one is added
    public LinkedNode next;
    private E contents;

    public E getContents() {
        return contents;
    }

    public void setContents(E c) {
        contents=c;
    }

    public void setNext(LinkedNode e)
    {
        next = e;
    }
}
