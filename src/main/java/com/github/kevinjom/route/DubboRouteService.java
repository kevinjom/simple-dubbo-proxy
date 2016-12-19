package com.github.kevinjom.route;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DubboRouteService {
    private final RoutesLoader routesLoader;
    private final Map<RequestKey, DubboConfig> dubboConfigCache;

    public DubboRouteService(RoutesLoader routesLoader) throws IOException {
        this.routesLoader = routesLoader;
        dubboConfigCache = fillDubboConfigCache();
    }

    private Map<RequestKey, DubboConfig> fillDubboConfigCache() throws IOException {
        return routesLoader.load().stream()
                .collect(Collectors.toMap(c -> new RequestKey(c.getHttpMethod(), c.getUrlPath()),
                        c -> c.getDubbo()));
    }


    public DubboInvocation get(RequestEntity<?> requestEntity) {
        //TODO: magic to map request to DubboInvocation by dubboConfigCache

        return new DubboInvocation(null, null, null);
    }


    static class RequestKey {
        private final String method;
        private final String path;

        RequestKey(String method, String path) {
            this.method = method;
            this.path = path;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RequestKey that = (RequestKey) o;
            return method == that.method &&
                    Objects.equals(path, that.path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(method, path);
        }
    }
}
