package winzinger.samples.defaultmethod;

/**
 * Created by rwinzing on 14.11.15.
 */
public interface CustomException {
    void setTraceId(String traceId);

    default void generateTraceId() {
        setTraceId("foobar");
    }

    default ErrorData getErrorData() {
        return ErrorData.build().withMessage("msg").withDetail("detail").withCause("cause");
    }

    class ErrorData {
        private String message;
        private String detail;
        private String cause;

        private ErrorData() {};

        public static ErrorData build() {
            return new ErrorData();
        }

        public ErrorData withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorData withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public ErrorData withCause(String cause) {
            this.cause = cause;
            return this;
        }

        public String getMessage() {
            return message;
        }

        public String getDetail() {
            return detail;
        }

        public String getCause() {
            return cause;
        }
    }
}
