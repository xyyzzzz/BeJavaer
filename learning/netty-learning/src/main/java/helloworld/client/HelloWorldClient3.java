package helloworld.client;

public class HelloWorldClient3 {
    private static final String HOST = "127.0.0.1";
    private static final int PORT= 9527;

    public static void main(String[] args){
        new HelloWorldClientMain().start(HOST,PORT,"王五");
    }
}