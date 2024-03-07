package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() throws Exception {
        Cars cars = new Cars(() -> true, 3);
        cars.drive();
        List<Integer> drivingDistances = cars.drivingDistances();

        assertThat(drivingDistances).containsExactly(1, 1, 1);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() throws Exception {
        Cars cars = new Cars(() -> false, 3);
        cars.drive();
        List<Integer> drivingDistances = cars.drivingDistances();

        assertThat(drivingDistances).containsExactly(0, 0, 0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void getResult() throws Exception {
        Cars cars = new Cars(() -> true, 3);

        cars.drive();
        assertThat(cars.getResult()).isEqualTo("-\n-\n-");

        cars.drive();
        assertThat(cars.getResult()).isEqualTo("--\n--\n--");
    }
}
