package com.insightfullogic.java8.examples.chapter5;

public class StringCombiner {

    private final String delim;
    private final String prefix;
    private final String suffix;
    private final StringBuilder builder;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        builder = new StringBuilder();
    }

    // BEGIN add
public StringCombiner add(String element) {
    if (areAtStart()) {
        builder.append(prefix);
    } else {
        builder.append(delim);
    }
    builder.append(element);
    return this;
}
    // END add

    private boolean areAtStart() {
        return builder.length() == 0;
    }

    // BEGIN merge
public StringCombiner merge(StringCombiner other) {
	if (other.builder.length() > 0) {
        if (areAtStart()) {
        	builder.append(prefix);
        } else {
        	builder.append(delim);
        }
        builder.append(other.builder, prefix.length(), other.builder.length());
    }
    return this;
}
    // END merge

    @Override
    public String toString() {
        if (areAtStart()) {
            builder.append(prefix);
        }
        builder.append(suffix);
        return builder.toString();
    }

}
