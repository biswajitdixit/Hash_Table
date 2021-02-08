package com.hash;
public class MyLinkedList<K> {
    public INode tail;
    public INode head;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }

    }

    public void append(INode myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null) {
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    public INode pop() {
        INode tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    public INode popLast() {
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        tail.setNext(tempNode);
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }

    public INode search(K key) {
        INode tempNode = this.head;
        while (tempNode != null) {
            if (tempNode.getKey().equals(key) || tempNode.equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }



    public void addInAscendingOrder(INode<K> newNode) {
        if (this.head == null) {
            this.head = newNode;
        } else if (((Comparable<K>) this.head.getKey()).compareTo(newNode.getKey()) > 0) {
            newNode.setNext(head);
            this.head = newNode;
        } else {
            INode<K> tempNode = this.head;
            while (tempNode.getNext() != null &&
                    ((Comparable<K>) tempNode.getNext().getKey()).compareTo(newNode.getKey()) < 0) {
                tempNode = tempNode.getNext();
            }
            newNode.setNext(tempNode.getNext());
            tempNode.setNext(newNode);
        }
        System.out.println("Ascending order : ");
        printMyNodes();
    }

    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public void deleteInMiddle(MyNode<Integer> key) {
        INode tempNode = this.head;
        while (!tempNode.getNext().equals(key)) {
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(tempNode.getNext().getNext());
        System.out.println("size of linklist:" + size());
    }

    public int size() {
        INode tempNode = this.head;
        int size = 0;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.getNext();
        }
        return size;
    }


    public void printMyNodes() {
        StringBuffer myNodes = new StringBuffer(" Nodes:-> ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail)) myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);

    }

    public void printMyNode() {
        System.out.println("my Nodes : " + head);
    }

    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head +
                '}';
    }
}