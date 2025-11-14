import java.util.*;

class Concurrency{

    static class Buffer{
        private final int size;
        private final LinkedList<Integer> list = new LinkedList<>();
        private boolean finished = false;

        Buffer(int size){
            this.size = size;
        }

        public synchronized void produce(int num) throws InterruptedException{
            while(list.size() == size){
                wait();
            }
            list.add(num);
            notifyAll();
        }

        public synchronized Integer consume() throws InterruptedException{
            while(list.isEmpty()){
                if(finished){
                    return null;
                }
                wait();
            }
            Integer num = list.removeFirst();
            notifyAll();
            return num;
        }

        public synchronized  void isFinished(){
            finished = true;
            notifyAll();
        }

    }

    public static void main(String[] args){
        Buffer buf = new Buffer(5);

        Thread producer = new Thread(() -> {
            try{
                for(int i=1;i<=50;i++){
                    buf.produce(i);
                }
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
            finally{
                buf.isFinished();
            }
        });

        Thread consumer = new Thread(() -> {
            try{
                Integer num;
                while((num = buf.consume()) != null){
                    System.out.println(num);
                }
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}