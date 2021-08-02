package prime;

import java.math.BigInteger;
import java.util.Random;

/**
 * Finger weg von dieser Klasse. Du sollst mit dem Interface PrimeApi arbeiten.
 */
public class PrimeApiImpl implements PrimeApi {


    @Override
    public BigInteger generatePrime() {
        Random random = new Random();
        if (random.nextInt(100) < CHANCE_TO_FAIL) {
            throw new RuntimeException("Irgendetwas ist schief gelaufen. Du musst mit dieser Exception klar kommen" +
                    " und dein Code darf nicht abstürzen.");
        }
        return BigInteger.probablePrime(BIT_LENGTH, random);

    }
}
