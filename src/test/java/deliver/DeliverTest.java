package deliver;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class DeliverTest {

    public static class DeliverTest_testGetContent {
        Deliver target;

        @Before
        public void setUp() throws Exception {
            target = new Deliver();
        }

        @Test
        public void pattern1() throws Exception {
            DeliverRequest req = new DeliverRequest("12345");
            assertThat(target.getContent(req), is("content1"));
        }

        @Test
        public void pattern2() throws Exception {
            DeliverRequest req = new DeliverRequest("00000");
            assertThat(target.getContent(req), is("NOTHING"));
        }
    }

    public static class DeliverTest_testCreateHtmlResponse {
        Deliver target;

        @Before
        public void setUp() throws Exception {
            target = new Deliver();
        }

        @Test
        public void pattern1() throws Exception {
            DeliverResponse result = target.createHtmlResponse("HIT");
            assertThat(result.getResponseHtml(), is("<html>HIT</html>"));
        }

        @Test
        public void pattern2() throws Exception {
            DeliverResponse result = target.createHtmlResponse("NOTHING");
            assertThat(result.getResponseHtml(), is("<html>NOTHING</html>"));
        }
    }
}