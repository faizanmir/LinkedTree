package com.dsAlgo;

public class Main {

    public static void main(String[] args) {

        LinkedTreeClass linkedTreeClass  = new LinkedTreeClass();
       linkedTreeClass.insert(1);
        linkedTreeClass.insert(6);
       linkedTreeClass.insert(2);
        linkedTreeClass.insert(3);
        linkedTreeClass.insert(4);
        linkedTreeClass.insert(7);
       linkedTreeClass.delete(1);
        linkedTreeClass.traverse(linkedTreeClass.getRoot());


    }
}
