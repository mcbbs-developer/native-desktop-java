package net.mcbbs.app.desktop.java.util.network;

import net.mcbbs.app.desktop.java.util.network.processor.ImmutableProcessorPipeline;
import net.mcbbs.app.desktop.java.util.thread.ThrowableRunnable;

public interface IServer<P> extends ThrowableRunnable {
    void addPipe(String pipe, ImmutableProcessorPipeline<P> pipeline);

    void enablePipe(String pipe);

    ImmutableProcessorPipeline<P> getPipe(String pipe);

    ImmutableProcessorPipeline<P> getActivated();

    abstract class Connection {
        final Thread processor;

        public Connection(Thread processor) {
            this.processor = processor;
        }

        public abstract void shutdown();
    }
}
