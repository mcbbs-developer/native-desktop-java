package net.mcbbs.app.desktop.java.util.network.processor.user;

import net.mcbbs.app.desktop.java.util.network.processor.IProcessorChainable;

public interface IDataUser<A> extends IProcessorChainable<A, A> {
    void onReceived(A data);
}
