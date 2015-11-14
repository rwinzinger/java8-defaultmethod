package winzinger.samples.defaultmethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by rwinzing on 14.11.15.
 */
public class ExceptionMapper {
    public String toResponse(Throwable t) {
        String jsonPresentation;
        ObjectMapper om = new ObjectMapper();

        if (t instanceof CustomException) {
            CustomException.ErrorData ed = ((CustomException)t).getErrorData();

            try {
                jsonPresentation = om.writeValueAsString(ed);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("unable to serialize", e);
            }
        } else {
            try {
                jsonPresentation = om.writeValueAsString(t.getMessage());
            } catch (JsonProcessingException e) {
                throw new RuntimeException("unable to serialize", e);
            }
        }

        return jsonPresentation;
    }
}
