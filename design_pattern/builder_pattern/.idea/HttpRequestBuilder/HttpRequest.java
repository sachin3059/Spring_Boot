import java.net.URI;
import java.time.Duration;
import java.util.*;

public final class HttpRequest {

    private final String method;
    private final URI url;
    private final Map<String, String> headers;
    private final byte[] body;
    private final Duration timeout;

    private HttpRequest(Builder builder) {
        this.method = builder.method;
        this.url = builder.url;
        this.headers = Map.copyOf(builder.headers); // immutable copy
        this.body = builder.body == null ? null : builder.body.clone(); // defensive copy
        this.timeout = builder.timeout;
    }

    // ---------- Getters (No Setters → Immutability) ----------

    public String getMethod() {
        return method;
    }

    public URI getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public byte[] getBody() {
        return body == null ? null : body.clone();
    }

    public Duration getTimeout() {
        return timeout;
    }

    // ---------- Entry Points ----------

    public static Builder builder() {
        return new Builder();
    }

    public static Builder get(String url) {
        return builder().method("GET").url(url);
    }

    public static Builder post(String url) {
        return builder().method("POST").url(url);
    }

    // ---------- Builder ----------

    public static final class Builder {

        private String method;
        private URI url;
        private Map<String, String> headers = new HashMap<>();
        private byte[] body;
        private Duration timeout = Duration.ofSeconds(10); // default

        private static final Set<String> ALLOWED_METHODS =
                Set.of("GET", "POST", "PUT", "DELETE", "PATCH");

        private Builder() {}

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder url(String url) {
            this.url = URI.create(url);
            return this;
        }

        public Builder header(String key, String value) {
            headers.put(key, value);
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            this.headers = new HashMap<>(headers);
            return this;
        }

        public Builder body(String body) {
            this.body = body == null ? null : body.getBytes();
            return this;
        }

        public Builder body(byte[] body) {
            this.body = body == null ? null : body.clone();
            return this;
        }

        public Builder timeoutSeconds(long seconds) {
            this.timeout = Duration.ofSeconds(seconds);
            return this;
        }

        public Builder timeout(Duration timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            validate();
            return new HttpRequest(this);
        }

        // ---------- Validation ----------

        private void validate() {
            validateMethod();
            validateUrl();
            validateGetBodyRule();
        }

        private void validateMethod() {
            if (method == null || !ALLOWED_METHODS.contains(method)) {
                throw new IllegalArgumentException(
                        "method must be one of GET, POST, PUT, DELETE, PATCH: '" + method + "' given"
                );
            }
        }

        private void validateUrl() {
            if (url == null || !url.isAbsolute()) {
                throw new IllegalArgumentException(
                        "url is not a valid absolute URL: '" + url + "' given"
                );
            }
        }

        private void validateGetBodyRule() {
            if ("GET".equals(method) && body != null) {
                throw new IllegalArgumentException(
                        "GET request must not include a body"
                );
            }
        }
    }
}