package ru.springgb.less11.actuator;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
public class MyServiceTimer {


    // ...
    private  Timer myTimer;

    public MyServiceTimer(Timer myTimer) {
        this.myTimer = myTimer;
    }


    public void MyService(MeterRegistry meterRegistry) {
        myTimer = Timer.builder("my_custom_timer")
                .description("Timing something very important")
                .register(meterRegistry);
    }


    public void doSomethingTimed() {
        myTimer.record(() -> {
            // Тут какая-то важная логика, время
            // выполнения которой мы хотим
            // замерить
        });
    }
}
