package Assignments;

import java.io.File;
import java.util.TreeMap;
import java.util.concurrent.*;

public class WordCountParallel {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String pathname = "C:\\Users\\badkass\\Desktop\\Thread-Plural\\src\\files";
        File folder = new File(pathname);
        File[] listOfFiles = folder.listFiles();

        ExecutorService service = Executors.newFixedThreadPool(5);
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    String filename = pathname + "\\" + listOfFiles[i].getName();
                    FutureTask<TreeMap<String, Integer>> task = new FutureTask(new MyCallable(filename));
                    service.submit(task);
                    try {
                        TreeMap<String, Integer> wordCount = task.get();
                        WordCount.printMap(wordCount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        service.shutdown();

    }
}

class MyCallable implements Callable<TreeMap<String, Integer>> {

    private String filename;

    public MyCallable(String filename) {
        this.filename = filename;
    }

    @Override
    public TreeMap<String, Integer> call() throws Exception {
        System.out.println("I am in thread" + Thread.currentThread().getName() + "and I am reading file : " + filename);

        return WordCount.readAndCount(filename);
    }
}
