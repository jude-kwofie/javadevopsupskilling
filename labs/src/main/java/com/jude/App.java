package com.jude;

import com.jude.linkedlist.ILinkedList;
import com.jude.stack.Calculator;
import com.jude.stack.Postfix;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Calculator cal = new Calculator("3*-4-10*10");
        cal.printResult();
    }

}

