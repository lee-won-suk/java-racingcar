package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.generator.SpecificNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarCollectionTest {
    @Test
    void nextStateGoForwardTest() {
        //given
        CarCollection cars = new CarCollection(List.of(
                new Car("test1", 2),
                new Car("test2", 4)));

        //when
        CarCollection carCollection = cars.nextState(new SpecificNumberGenerator(9));

        //then
        assertThat(carCollection).isEqualTo(new CarCollection(List.of(
                new Car("test1", 3),
                new Car("test2", 5)
        )));
    }

    @Test
    void nextStateDontGoForwardTest() {
        //given
        CarCollection cars = new CarCollection(List.of(
                new Car("test1", 2),
                new Car("test2", 4)));

        //when
        CarCollection carCollection = cars.nextState(new SpecificNumberGenerator(0));

        //then
        assertThat(carCollection).isEqualTo(new CarCollection(List.of(
                new Car("test1", 2),
                new Car("test2", 4)
        )));
    }

    @Test
    void getWinnersTest() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2", 2));
        cars.add(new Car("test3", 2));
        CarCollection carCollection = new CarCollection(cars);

        //when
        List<String> result = carCollection.getWinners();

        //then
        Assertions.assertThat(result.get(0)).isEqualTo("test2");
        Assertions.assertThat(result.get(1)).isEqualTo("test3");
    }
}