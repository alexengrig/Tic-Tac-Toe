class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        String hours = this.hours > 9 ? String.valueOf(this.hours) : "0" + this.hours;
        String minutes = this.minutes > 9 ? String.valueOf(this.minutes) : "0" + this.minutes;
        String seconds = this.seconds > 9 ? String.valueOf(this.seconds) : "0" + this.seconds;
        return String.join(":", hours, minutes, seconds);
    }
}