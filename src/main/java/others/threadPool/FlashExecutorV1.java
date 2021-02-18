package others.threadPool;


import java.util.concurrent.Executor;

public class FlashExecutorV1 implements Executor {

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
