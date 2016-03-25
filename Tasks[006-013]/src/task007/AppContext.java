package task007;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Denis on 22.03.16.
 */

@Configuration
@ComponentScan(basePackages = {"task007"})
public class AppContext {
    @Bean Age aircraftAge() {
        return new Age(2, 4, 20);
    }
    @Bean Age pilotAge() {
        return new Age(6, 5, 30);
    }
    @Bean Age navigatorAge() {
        return new Age(10, 2, 32);
    }

    @Bean
    public AircraftCarrier aircraftCarrier() {
        return new AircraftCarrier();
    }
    @Bean
    public Submarine submarine() {
        return new Submarine();
    }
    @Bean
    public Aircraft opponentAircraft() {
        return new Aircraft();
    }
    @Bean
    public Airport airport() {
        return new Airport();
    }
}
