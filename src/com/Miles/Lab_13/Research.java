package com.Miles.Lab_13;

public class Research {
    private int TimeForResearch;

    public void addTimeForResearch(int timeForResearch) throws TryIncorrectFormat {
        if (timeForResearch < 0)
        {
            throw new TryIncorrectFormat();
        }
        TimeForResearch += timeForResearch;
    }

    @Override
    public String toString() {
        return "Research{" +
                "TimeForResearch=" + TimeForResearch +
                '}';
    }
}
