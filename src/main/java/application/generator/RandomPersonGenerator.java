package application.generator;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class RandomPersonGenerator {

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate birthDate;
    private String personalUUID;

    public RandomPersonGenerator() {
        Faker faker = new Faker();
        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());
        LocalDate randomBirthDate = getRandomBirthDate();
        setBirthDate(randomBirthDate);
        int age = LocalDate.now().getYear() - randomBirthDate.getYear();
        setAge(age);
        setPersonalUUID(UUID.randomUUID().toString());
    }

    private LocalDate getRandomBirthDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1920, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2001, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        return randomBirthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonalUUID() {
        return personalUUID;
    }

    public void setPersonalUUID(String personalUUID) {
        this.personalUUID = personalUUID;
    }
}
