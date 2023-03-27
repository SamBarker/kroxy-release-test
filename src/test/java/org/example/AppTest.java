package org.example;

import org.junit.jupiter.api.Test;

import io.kroxylicious.proxy.KafkaProxy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Test
    void shouldCreateProxyInstance() {
        //Given

        //When
        try (KafkaProxy kafkaProxy = App.startProxy("etc/example-proxy-config.yml")) {

            //Then
            assertThat(kafkaProxy).isNotNull();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
