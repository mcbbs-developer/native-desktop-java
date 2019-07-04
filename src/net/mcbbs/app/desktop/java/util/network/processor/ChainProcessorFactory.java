package net.mcbbs.app.desktop.java.util.network.processor;

import net.mcbbs.app.desktop.java.util.thread.SingleArgumentRunnable;
import net.mcbbs.app.desktop.java.util.network.processor.user.IDataUser;

public final class ChainProcessorFactory {
    public static <A> IDataUser<A> newSimpleDataUser(Class<A> aClass, SingleArgumentRunnable<A> runnable) {
        return new IDataUser<A>() {
            @Override
            public void setValue(A value) {
            }

            @Override
            public A value() {
                return null;
            }

            @Override
            public void onReceived(A data) {
                runnable.runWithArg(data);
            }

            @Override
            public Class<A> getInputType() {
                return aClass;
            }

            @Override
            public Class<A> getOutputType() {
                return aClass;
            }

            @Override
            public A procChain(A o) {
                onReceived(o);
                return o;
            }
        };
    }
}
