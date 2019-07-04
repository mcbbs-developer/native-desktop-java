package net.mcbbs.app.desktop.java.util.network.processor.coder;

import net.mcbbs.app.desktop.java.util.network.processor.IProcessorChainable;

public interface IEncoder<I, O> extends IProcessorChainable<I, O> {
    O encode(I data);
}
