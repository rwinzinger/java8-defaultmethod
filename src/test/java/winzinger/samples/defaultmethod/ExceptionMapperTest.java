package winzinger.samples.defaultmethod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rwinzing on 14.11.15.
 */
public class ExceptionMapperTest {
    private ExceptionMapper em = new ExceptionMapper();

    @Test
    public void testMappingOfNullPointerException() {
        assertEquals("\"npe\"", em.toResponse(new NullPointerException("npe")));
    }

    @Test
    public void testMappingOfCustomCheckedException() {
        assertEquals("{\"message\":\"msg\",\"detail\":\"detail\",\"cause\":\"cause\"}", em.toResponse(new CustomCheckedException()));
    }

    @Test
    public void testMappingOfCustomUncheckedException() {
        assertEquals("{\"message\":\"msg\",\"detail\":\"detail\",\"cause\":\"cause\"}", em.toResponse(new CustomUncheckedException()));
    }

    @Test
    public void testMappingOfExtendedUncheckedException() {
        assertEquals("{\"message\":\"msg\",\"detail\":\"detail\",\"cause\":\"cause\",\"id\":123}", em.toResponse(new SomeExtendedUncheckedException()));
    }
}
