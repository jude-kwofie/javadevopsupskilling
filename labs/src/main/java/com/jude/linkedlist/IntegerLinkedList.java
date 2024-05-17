package com.jude.linkedlist;

import java.util.LinkedList;

public class IntegerLinkedList {
    private final LinkedList<Integer> integersLinkedList;
    public IntegerLinkedList(){
        this.integersLinkedList = new LinkedList<>();
    }
    public void append(int integerValue){
        integersLinkedList.addLast(integerValue);
    }
   public void prepend(int integerValue){
        integersLinkedList.addFirst(integerValue);
    }

    public int getValueByIndex(int integerIndex){
        return integersLinkedList.get(integerIndex);
    }
    public boolean search(int integerValue){
        for(int value: integersLinkedList){
            if(value==integerValue){
                return true;
            }
        }
        return false;
    }
    public boolean delete(int integerValue){
        return integersLinkedList.remove( Integer.valueOf(integerValue));
    }

    public void  printIntegerLinkedList(){
        for(int value: integersLinkedList){
            System.out.println(value);
        }
    }


}

