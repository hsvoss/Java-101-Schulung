package utils;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;

/**
 * Vielleicht findest du diese Klasse nützlich
 */
public class PrimeAndInstant {
    private BigInteger prime;
    private Instant instant;

    public PrimeAndInstant(BigInteger prime, Instant duration) {
        this.prime = prime;
        this.instant = duration;
    }

    public BigInteger getPrime() {
        return prime;
    }

    public Instant getInstant() {
        return instant;
    }
}
