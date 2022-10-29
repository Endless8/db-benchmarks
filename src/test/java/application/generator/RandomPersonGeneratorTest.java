package application.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomPersonGeneratorTest {

    @Test
    void testRandomPersonGeneration() {
        RandomPersonGenerator randomPersonGenerator = new RandomPersonGenerator();
        boolean hasFirstName = randomPersonGenerator.getFirstName() != null;
        boolean hasLastName = randomPersonGenerator.getLastName() != null;
        boolean hasBirthDate = randomPersonGenerator.getBirthDate() != null;
        boolean hasAge = randomPersonGenerator.getAge() >= 0;
        boolean hasPersonalUUID = randomPersonGenerator.getPersonalUUID() != null;
        assertTrue(hasFirstName && hasLastName && hasBirthDate && hasAge && hasPersonalUUID);
    }

}