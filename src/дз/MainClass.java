package дз;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        // сериализация  и десериализация через objectOutPutStream
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("workers.txt"))){
            List<Worker> workers = new ArrayList<>();
            workers.add(new Worker("work1",20,false));
            workers.add(new Worker("work2",22,false));
            workers.add(new Worker("work3",30,false));
            workers.add(new Worker("work4",23,true));
            workers.add(new Worker("work5",31,false));
            workers.add(new Worker("work6",19,false));
            workers.add(new Worker("work7",37,false));
            workers.add(new Worker("work8",32,false));
            workers.add(new Worker("work9",31,true));
            workers.add(new Worker("work10",36,false));
            workers.add(new Worker("work11",27,false));
            workers.add(new Worker("work12",47,false));
            workers.add(new Worker("work13",51,false));
            workers.add(new Worker("work14",59,false));
            workers.add(new Worker("work15",30,true));
            workers.add(new Worker("work16",60,false));
            workers.add(new Worker("work17",22,false));
            workers.add(new Worker("work18",36,false));
            workers.add(new Worker("work19",44,false));
            workers.add(new Worker("work20",97,true));
            objectOutputStream.writeObject(workers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("workers.txt"))){
            Object workersList = objectInputStream.readObject();
            System.out.println("Workers List  - \n" + workersList);

        } catch (IOException  | ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}
class Worker implements Serializable{
    private String name;
    private int age;
    private boolean vacation;

    public Worker(String name, int age, boolean vacation) {
        this.name = name;
        this.age = age;
        this.vacation = vacation;
    }

    @Override
    public String toString() {
        return "Worker  {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", vacation=" + vacation +
                '}' + "\n";
    }
}
