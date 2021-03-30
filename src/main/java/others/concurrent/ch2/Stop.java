package others.concurrent.ch2;


public class Stop {
    public static User user = new User();

    public static class User {
        private int id;
        private String name;
        public User(){}
        @Override
        public String toString(){
            return "id=" + id + "," + "name=" + name;
        }

        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class ChangeObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    int v = (int) System.currentTimeMillis() / 1000;
                    user.setId(v);
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread{

        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.valueOf(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        new ReadObjectThread().start();
        while (true) {
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            t.stop();
            //sth goes wrong with this program
        }

    }




}
