package winzinger.samples.defaultmethod;

/**
 * Created by rwinzing on 14.11.15.
 */
public class SomeExtendedUncheckedException extends CustomUncheckedException {
    @Override
    public ErrorData getErrorData() {
        return ExtendedErrorData.build().fromErrorData(super.getErrorData()).withId(123);
    }

    static class ExtendedErrorData extends ErrorData {
        private int id;

        public static ExtendedErrorData build() {
            return new ExtendedErrorData();
        }

        public ExtendedErrorData fromErrorData(ErrorData ed) {
            this.message = ed.message;
            this.detail = ed.detail;
            this.cause = ed.cause;
            return this;
        }

        public ExtendedErrorData withId(int id) {
            this.id = id;
            return this;
        }

        public int getId() {
            return id;
        }
    }
}
