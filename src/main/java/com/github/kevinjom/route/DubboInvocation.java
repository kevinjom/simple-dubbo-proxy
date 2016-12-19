package com.github.kevinjom.route;

public class DubboInvocation {
    private final String interfaze;
    private final String method;
    private final Object[] args;

    public DubboInvocation(String interfaze, String method, Object... args) {
        this.interfaze = interfaze;
        this.method = method;
        this.args = args;
    }


    public String getInterfaze() {
        return interfaze;
    }

    public String getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }
}
