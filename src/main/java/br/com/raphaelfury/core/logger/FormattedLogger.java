package br.com.raphaelfury.core.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FormattedLogger {

	private static final String LOG_PREFIX_FORMAT = "[%s]";

	private final Logger handle;
	private final FormattedLogger parent;
	private final boolean debugMode;

	private String prefix, logPrefix;

	public FormattedLogger(Logger handle, String prefix, boolean debugMode) {
		this.handle = handle;
		this.parent = null;
		this.prefix = prefix;
		this.debugMode = debugMode;

		this.logPrefix = buildPrefix(new StringBuilder());
	}

	public FormattedLogger(FormattedLogger parent, String prefix) {
		this.handle = parent.handle;
		this.parent = parent;
		this.prefix = prefix;
		this.debugMode = parent.hasDebug();

		this.logPrefix = buildPrefix(new StringBuilder());
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
		this.logPrefix = buildPrefix(new StringBuilder());
	}

	private String buildPrefix(StringBuilder builder) {
		if (prefix != null) {
			builder.insert
			
			(0, String.format(LOG_PREFIX_FORMAT, prefix));
		}
		return parent == null ? builder.length() < 1 ? "" : builder + " " : parent.buildPrefix(builder);
	}

	public void log(String format, Object... args) {
		log(Level.INFO, null, String.format(format, args));
	}

	public void log(String message) {
		log(Level.INFO, null, message);
	}

	public void log(long time, String message) {
		log(Level.INFO, time, message);
	}

	public void log(long time, String message, Object... args) {
		log(Level.INFO, time, String.format(message, args));
	}

	public void log(Level level, String format, Object... args) {
		log(level, null, String.format(format, args));
	}

	public void log(Level level, String message) {
		log(level, null, message);
	}

	public void log(Level level, long time, String message) {
		log(level, null, "[" + formatNanoTime(time, System.nanoTime()) + "] " + message);
	}

	public void log(Level level, Throwable ex, String format, Object... args) {
		log(level, ex, String.format(format, args));
	}

	public void log(Level level, Throwable ex, String message) {
		handle.log(level, logPrefix + message, ex);
	}

	public void debug(long time, String message) {
		debug("[" + formatNanoTime(time, System.nanoTime()) + "] " + message);
	}

	public void debug(String message) {
		if (hasDebug())
			log(Level.WARNING, null, message);
	}

	public void error(String message) {
		log(Level.SEVERE, null, message);
	}

	public void error(String message, Throwable throwable) {
		log(Level.SEVERE, throwable, message);
	}

	public boolean hasDebug() {
		return debugMode;
	}

	public static String formatNanoTime(long start, long end) {
		long ns = end - start;
		long nano = (long) ((ns / 1000) % 1000);
		long ms = ns / 1000000;
		long millis = (long) (ms % 1000);
		long seconds = (long) (ms / 1000) % 60;
		long minutes = (long) (ms / (1000 * 60)) % 60;
		long hour = (long) (ms / (1000 * 60 * 60) % 24);
		return (hour > 0 ? hour + "h " : "") + (minutes > 0 ? minutes + "m " : "") + (seconds > 0 ? seconds + "s " : "") + (millis > 0 ? millis + "ms " : "") + (nano > 0 ? nano + "ns" : "");
	}

}
