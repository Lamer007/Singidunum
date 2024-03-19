
package com.mycompany.les12;

class MyExecption extends Exception {
    String message;

    public MyExecption (String str) {
        this.message = str;
    }

    @Override
    public String toString() {
        return "This is my exception " + message;
    }

}


public class Les12 {
    public static void main(String[] args) {
        try {
            throw new MyExecption("This is my message");
        } catch (MyExecption e)
        {
            System.err.println(e);
        }
    }
}
