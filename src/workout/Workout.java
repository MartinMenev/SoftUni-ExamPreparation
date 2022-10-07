package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private final List<Exercise> exercises;
    private final String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exerciseCount > 0) {
            exercises.add(exercise);
        }
        exerciseCount--;
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                exerciseCount++;
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise exerciseToReturn = null;
        int maxCal = Integer.MIN_VALUE;
        for (Exercise exercise : exercises) {
            if (exercise.getBurnedCalories() > maxCal) {
                exerciseToReturn = exercise;
                maxCal = exercise.getBurnedCalories();
            }
        }
            return exerciseToReturn;
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append("Workout type: ").append(type).append("\n");
        for (Exercise exercise : exercises) {
            text.append(exercise).append("\n");
        }
        return text.toString();
    }
}
