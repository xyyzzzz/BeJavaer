package helloworld;

public class HelloWorldClient2 {
    private static final String HOST = "127.0.0.1";
    private static final int PORT= 8080;

    public static void main(String[] args){
        new HelloWorldClientMain().start(HOST,PORT,"李四");
    }
}