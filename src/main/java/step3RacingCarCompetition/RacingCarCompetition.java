package step3RacingCarCompetition;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RacingCarCompetition {
    private final String GO = "-";
    private final String STOP = "";
    private final int TOTALCARNUMBER_INDEX = 0;
    private final int TOTALMOVINGCOUNT_INDEX = 1;

    public void startRacing() {
        List<Integer> inputCarData = InputView.insertRacingCarData();
        int totalNumberOfCars = inputCarData.get(TOTALCARNUMBER_INDEX);
        int totalMovingCount = inputCarData.get(TOTALMOVINGCOUNT_INDEX);

        RacingCarInfo racingCarInfo = new RacingCarInfo(totalNumberOfCars);
        IntStream.range(0, totalMovingCount).forEachOrdered(movingTryCount -> {
            IntStream.range(0, totalNumberOfCars).forEachOrdered(numberOfCars -> {
                racingCarInfo.recordGoInRacingCarData(numberOfCars, moveStopDecision(randomNumber()));
                ResultView.printCurrentCarMovement(racingCarInfo.findRacingCarData(numberOfCars));
            });
            ResultView.printNewLine();
        });
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public String moveStopDecision(int randomNumber) {
        return randomNumber >= 4 ? GO : STOP;
    }
}
