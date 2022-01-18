package task3;


public class task3_1 extends Thread {
    static Thread t1,t2;
    public static void main(String[] args) throws InterruptedException {
        int arr1[]={1,3,5,7,9};
        int arr2[]={2,4,6,8,10,11,12,13,14};
        OutputArr(arr1,arr2);

    }

    public static void OutputArr(int arr1[], int arr2[]) throws InterruptedException {
        t1 = new Thread() {
            @Override
            public void run() {
                for(int i:arr1){
                    System.out.println(Thread.currentThread().getName()+": "+i+" ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        t2 = new Thread(){
            @Override
            public void run() {
                for (int i : arr2) {
                    System.out.println(Thread.currentThread().getName()+": "+i+" ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();



    }



}

