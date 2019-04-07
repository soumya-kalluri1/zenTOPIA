import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.StringBuilder;

public class TrackDay
{
    private ArrayList<TrackHour> hours;
    private String data;
    private int numMinutes;

    /**
     * constructor for TrackDay, reads data from file and builds day
     */
    public TrackDay(String filename) throws IOException
    {
        this.readData(filename); //read data from file
        this.hours = new ArrayList<TrackHour>();
        this.fillHours(); //fill hours array based on data from the file

        System.out.println(numMinutes);
    }

    /**
     * read data from the file, place it into the 'data' instance variable
     * @param filename The name of the file to read
     */
    private void readData(String filename) throws IOException
    {
        File myFile = new File(filename);
        Scanner myScanner = new Scanner(myFile);

        StringBuilder mySB = new StringBuilder();

        //read lines from file
        while(myScanner.hasNextLine())
        {
            mySB.append(myScanner.nextLine());
            mySB.append("\n");
            this.numMinutes++; //increment number of hours of data in day
        }

        myScanner.close(); //close scanner

        this.data = mySB.toString(); //set data
    }

    private void fillHours()
    {
        int startLine; //index in the string the line starts on
        int endLine; //index int the string the line ends on

        int currLineNum = 0; //the number of the current line in question
        String currLine;

        boolean end = false; //keep track of when the end is reached

        //initialize startLine for first iteration of loop
        startLine = this.data.indexOf('\n') + 1;

        //loop iterates once for every new hour
        while(true)
        {
            StringBuilder mySB = new StringBuilder();

            endLine = data.indexOf('\n', startLine) + 1; //find end of the line

            //no further \n symbols found
            if(endLine == -1)
            {
                break;
            }

            //current line of data to read
            currLine = this.data.substring(startLine, endLine);

            //hour to match
            int matchHour = Integer.parseInt(currLine.substring(
                            currLine.indexOf(',') + 1, currLine.indexOf(':')));

            int numMinutesHr = 0; //number of minutes of data for this hour

            //loop through lines after that until new hour is reached
            while(checkHoursMatch(currLine, matchHour) == true)
            {
                mySB.append(currLine); //append line to StringBuilder
                currLineNum++;
                numMinutesHr++;

                //end loop if all lines have been read
                if(currLineNum > this.numMinutes)
                {
                    end = true;
                    break;
                }

                //set up for next iteration of loop
                startLine = endLine;
                endLine = data.indexOf('\n', startLine) + 1; //find end of line
                //no next line
                if(endLine == 0)
                {
                    end = true;
                    break;
                }
                currLine = this.data.substring(startLine, endLine);
            }

            //create new TrackHour and add it to the list of hours in this day
            this.hours.add(new TrackHour(mySB.toString(),
                                                 matchHour, numMinutesHr));

            //end loop if all lines have been read
            if(currLineNum + 1 > this.numMinutes || end == true)
            {
                System.out.println("currLineNum = " + currLineNum);
                System.out.println("numMinutes = " + this.numMinutes);
                System.out.println("end = " + end);
                break;
            }
        }
    }

    /**
     * checks if the data from the string has the same hour as the input
     * @param line The string to get the hour from
     * @param toMatch The value to compare the resulting hour with
     */
    private static boolean checkHoursMatch(String line, int toMatch)
    {
        //get the hour from the line of data inputted
        int lineHour = Integer.parseInt(line.substring(line.indexOf(',') + 1,
                                               line.indexOf(':')));
        if(lineHour == toMatch)
        {
            return true; //the hours match
        }

        else
        {
            return false; //the hours do not match
        }
    }

    public void printDay()
    {
        for(int i = 0; i < this.hours.size(); i++)
        {
            this.hours.get(i).printHour();
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        try{
        TrackDay test = new TrackDay("tester.txt");

        test.printDay();
       }
       catch(IOException e)
       {System.out.println("didn't work :(");}


    }
}
