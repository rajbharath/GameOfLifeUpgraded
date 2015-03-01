package main.game;

public class PopulationManager {
    public static boolean getNextGenerationLife(boolean life, int neighbourCount) {
        if (life) {
            return getGenerationForLiveCell(neighbourCount);
        }
        return getNextGenerationLifeStatusForDeadCell(neighbourCount);
    }

    private static boolean getGenerationForLiveCell(int neighbourCount) {
        if (neighbourCount == 2 || neighbourCount == 3) return true;
        return false;
    }

    private static  boolean getNextGenerationLifeStatusForDeadCell(int neighbourCount) {
        if (neighbourCount == 3) return true;
        return false;
    }
}
