package utils;

import java.math.BigInteger;
import java.time.Duration;

/**
 * Vielleicht findest du diese Klasse nützlich
 */
public class PrimeAndDuration {
    private BigInteger prime;
    private Duration duration;

    public PrimeAndDuration(BigInteger prime, Duration duration) {
        this.prime = prime;
        this.duration = duration;
    }

    public BigInteger getPrime() {
        return prime;
    }

    public Duration getDuration() {
        return duration;
    }
}
