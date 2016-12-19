package com.github.kevinjom.route;

public class Route {
    private String httpMethod;
    private String urlPath;
    private DubboConfig dubbo;


    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public DubboConfig getDubbo() {
        return dubbo;
    }

    public void setDubbo(DubboConfig dubbo) {
        this.dubbo = dubbo;
    }
}
