package ru.springgb.less11.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;


//счетчики
@Service
public class MyService {
    private final Counter myCounter;

    public MyService(MeterRegistry meterRegistry) {
        myCounter = Counter.builder("my_custom_counter")
                .description("Counts something very important")
                .register(meterRegistry);
    }

    public void doSomethingImportant() {
        // Тут какая-то важная логика
        myCounter.increment();
    }
}
