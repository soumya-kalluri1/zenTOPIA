import java.lang.Integer;

public class TrackMinute
{
    private int day;
    private int hour;
    private int minute;

    private int heartRate;
    private int movement;

    private static int DAY_COLUMN = 0;

    public TrackMinute(String data)
    {
        //initialize instance variables
        this.setDay(data);
        int next = this.setTime(data);
        this.setHeartRate(data, next);
        this.setMovement(data);
    }

    /**
     * set the day, as an int in the format yearmonthday
     */
    private void setDay(String data)
    {
        //data for day is located in the first column
        int commaIndex = data.indexOf(',');
        this.day = Integer.parseInt(data.substring(0, commaIndex));
    }

    /**
     * set the hour and minute
     */
    private int setTime(String data)
    {
        //data for hour is located in the second column
        int startIndex = data.indexOf(',') + 1;
        int endIndex = data.indexOf(':', startIndex);
        this.hour = Integer.parseInt(data.substring(startIndex, endIndex));

        //data for minute is also located in the second column
        int temp = endIndex;
        endIndex = data.indexOf(',', endIndex);
        startIndex = temp + 1;
        this.minute = Integer.parseInt(data.substring(startIndex, endIndex));

        return endIndex;
    }

    /**
     * set the heart rate
     */
    private void setHeartRate(String data, int next)
    {
        //data for heart rate is in the third column
        int startIndex = data.indexOf(',', next) + 1;
        int endIndex = data.lastIndexOf(',');
        this.heartRate = Integer.parseInt(data.substring(startIndex, endIndex));
    }

    /**
     * set the movement
     */
    private void setMovement(String data)
    {
        //data for movement is in the last column
        int startIndex = data.lastIndexOf(',') + 1;
        this.movement = Integer.parseInt(data.substring(startIndex,
                                                        data.length()));
    }

    /**
     * getter for 'minute' instance variable
     */
    public int getMinute()
    {
        return this.minute;
    }

    /**
     * getter for 'heartRate' instance variable
     */
    public int getHeartRate()
    {
        return this.heartRate;
    }

    /**
     * getter for 'movement' instance variable
     */
    public int getMovement()
    {
        return this.movement;
    }

    public void printMinute()
    {
        System.out.print("day: " + this.day);
        System.out.print(", hour: " + this.hour);
        System.out.println(", minute: " + this.minute);
        System.out.println("-----------------------------------");
        System.out.println("heart rate: " + this.heartRate);
        System.out.println("movement: " + this.movement);
    }

    public static void main(String[] args)
    {
        String testData = "20190406,19:18,65,10\n";
        TrackMinute test = new TrackMinute(testData);
    }

}
