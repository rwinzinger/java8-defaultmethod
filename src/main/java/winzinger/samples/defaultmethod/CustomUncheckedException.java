package winzinger.samples.defaultmethod;

/**
 * Created by rwinzing on 14.11.15.
 */
public class CustomUncheckedException extends RuntimeException implements CustomException {
    @Override
    public void setTraceId(String traceId) {

    }
}
