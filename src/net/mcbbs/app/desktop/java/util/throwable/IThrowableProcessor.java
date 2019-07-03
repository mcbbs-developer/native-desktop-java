package net.mcbbs.app.desktop.java.util.throwable;

import javax.annotation.Nonnull;

public interface IThrowableProcessor {
    void process(@Nonnull Throwable t);
}
