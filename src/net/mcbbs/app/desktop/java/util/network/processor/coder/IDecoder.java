package net.mcbbs.app.desktop.java.util.network.processor.coder;

import net.mcbbs.app.desktop.java.util.network.processor.IProcessorChainable;

interface IDecoder<I, O> extends IProcessorChainable<I, O> {
    I decode(O data);
}
