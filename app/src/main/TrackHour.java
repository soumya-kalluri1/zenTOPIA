import java.util.ArrayList;

public class TrackHour
{
    private ArrayList<TrackMinute> minutes;
    private int hour;

    /**
     * constructor for TrackHour,
     * @param data The string that contains the minutes of data
     * @param hour The hour of the day this instance of TrackHour represents
     * @param numMinutes The number of minutes of data this hour has
     */
    public TrackHour(String data, int hour, int numMinutes)
    {
        this.minutes = new ArrayList<TrackMinute>();
        this.hour = hour;
        this.fillMinutes(data, numMinutes);
    }

    /**
     * fill the array with the minutes of data for this hour
     * @param data The string that contains the lines of data
     * @param numMinutes The number of minutes of data this hour has
     */
    private void fillMinutes(String data, int numMinutes)
    {
        int startIndex = 0;
        int endIndex;

        for(int i = 0; i < numMinutes; i++)
        {
            endIndex = data.indexOf('\n', startIndex);

            //get line from CSV that corresponds to the minute at i
            String line = data.substring(startIndex, endIndex);
            this.minutes.add(new TrackMinute(line));

            startIndex = endIndex + 1;
        }
    }

    /**
     * getter for 'hour' instance variable
     */
    public int getHour()
    {
        return this.hour;
    }

    /**
     * getter for 'minutes' instance variable
     */
    public ArrayList<TrackMinute> getMinutes()
    {
        return this.minutes;
    }

    public void printHour()
    {
        System.out.println("**********");
        System.out.println("Hour: " + this.hour);
        System.out.println("**********");

        for(int i = 0; i < this.minutes.size(); i++)
        {
            this.minutes.get(i).printMinute();
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        String test =
           "20190406,19:18,65,10\n" + "20190406,21:20,50,12\n"
            + "20190407,00:52,60,11\n";
        TrackHour testStuff = new TrackHour(test,12,3);
        //testStuff.printHour();
    }
}
