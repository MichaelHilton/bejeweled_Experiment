class BejeweledScore {
    private int current = 0;

    public void addToScore(int points) {
        int multiplier = points - 2;
        this.current += (points * multiplier);
    }

    public int getScore() {
        return this.current;
    }

    public void resetScore() {
        this.current = 0;
    }
}
