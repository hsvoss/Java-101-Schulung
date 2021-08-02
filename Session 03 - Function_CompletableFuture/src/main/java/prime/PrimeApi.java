package prime;

import java.math.BigInteger;

public interface PrimeApi {
    int BIT_LENGTH = 3000;  // Anpassen, falls die Laufzeit nicht ca. 1-5 Sekunden beträgt
    int CHANCE_TO_FAIL = 0; // Prozentuale Chance, dass eine RuntimeException fliegt.
    // Am Anfang lassen wir das erst mal bei 0 Prozent ;-)

    BigInteger generatePrime();


}
