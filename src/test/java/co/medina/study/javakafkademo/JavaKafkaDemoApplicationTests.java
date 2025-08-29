package co.medina.study.javakafkademo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaKafkaDemoApplicationTests {

    @InjectMocks
    private JavaKafkaDemoApplication application;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(application);
    }

}
