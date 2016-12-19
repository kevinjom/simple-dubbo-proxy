package com.github.kevinjom.route;

public class DubboConfig {
    private String interfaze;
    private String method;
    private Integer[] pathParamIndex;

    public String getInterfaze() {
        return interfaze;
    }

    public void setInterfaze(String interfaze) {
        this.interfaze = interfaze;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer[] getPathParamIndex() {
        return pathParamIndex;
    }

    public void setPathParamIndex(Integer[] pathParamIndex) {
        this.pathParamIndex = pathParamIndex;
    }
}
