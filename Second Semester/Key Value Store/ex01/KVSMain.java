package ex01;

import java.util.Scanner;

public class KVSMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nextString;
        int countOfCommands = 0;
        KVPInputStream kvpInputStream = new KVPInputStream();

        try {
            kvpInputStream.readKVP();

        } catch (Exception e) {
            // TODO: handle exception
        }
        do {
            System.out.println(
                    "Welcome! Please input your command (new ,get,update or delete), write exit to exit the programm");

            nextString = sc.next();

            if (nextString.equals("new")) {
                try {
                    System.out.println("Please input your key");
                    String key = sc.next();
                    System.out.println("Please input your value");
                    String value = sc.next();
                    kvpInputStream.kvs.newKVP(key, value);
                    countOfCommands++;

                } catch (IllegalArgumentException e) {
                    System.out.println("That key already exist");
                }

            }
            if (nextString.equals("get")) {
                try {
                    System.out.println("Please input your key");
                    String key = sc.next();
                    kvpInputStream.kvs.getKVP(key);
                } catch (IllegalArgumentException e) {
                    System.out.println("No such key");
                }

            }
            if (nextString.equals("update")) {
                try {
                    System.out.println("Please input your key");
                    String key = sc.next();
                    System.out.println("Please input your new value");
                    String newValue = sc.next();
                    kvpInputStream.kvs.updateKVP(key, newValue);
                    countOfCommands++;

                } catch (IllegalArgumentException e) {
                    System.out.println("No such key");
                }

            }
            if (nextString.equals("delete")) {
                try {
                    System.out.println("Please input your key");
                    String key = sc.next();
                    kvpInputStream.kvs.deleteKVP(key);
                    countOfCommands++;
                } catch (IllegalArgumentException e) {
                    System.out.println("No such key");
                }


            }
            if (countOfCommands >= 5 && countOfCommands % 5 == 0) {
                try {
                    KVPOutputStream kvo = new KVPOutputStream();
                    for (int i = 0; i < kvpInputStream.kvs.arrayObjectPairs.length; i++) {
                        kvo.writeKVP(kvpInputStream.kvs.arrayObjectPairs[i]);
                    }
                } catch (Exception exception) {

                }

            }
        } while (!nextString.equals("exit"));
    }
}
