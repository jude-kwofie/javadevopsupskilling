package com.jude;

import com.jude.linkedlist.ILinkedList;
import com.jude.stack.Postfix;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ILinkedList ilinkedList = new ILinkedList();
//        ilinkedList.prepend(5);
//        ilinkedList.prepend(6);
////        ilinkedList.append(1);
//        ilinkedList.append(2);
////        ilinkedList.prepend(1);
//        ilinkedList.append(1);
//        ilinkedList.remove(1);
//        ilinkedList.insertByIndex(3,10);
////        System.out.println(ilinkedList.search(7));
//        ilinkedList.printList();

        Postfix postfix = new Postfix();
        postfix.parseString("3+3-3*2");
        postfix.convertStringToToken("2+4+-8");
        postfix.printPostFix();
    }

}
