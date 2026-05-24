import java.util.*;
public class ChordFinder
{
    public static void main(String[] args)
    {
       Scanner sc =new Scanner(System.in);
       String notes[]={"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};//stores all the musical notes
       String chordTypes[]={"major","minor","minor","major","major","minor","dim"};//stores all the chord types
       int intervals[]={2,2,1,2,2,2,1};//stores the intervals between each note of the major scale
       System.out.println("======================");
       System.out.println("SCALE AND CHORD FINDER");
       System.out.println("======================");
       System.out.println("Enter the root note:");
       String root=sc.nextLine().toUpperCase();
       int rootIndex=-1;
       for(int i=0;i<notes.length;i++)//loop to check for valid musical note
       {
        if(notes[i].equalsIgnoreCase(root))//checks if current element is the same as the root note
           {
            rootIndex=i;
            break;//exits loop when the root is found
           }
       }
       if(rootIndex==-1)
        {
            System.out.println("Invalid musical note!");
        }
       else 
       {
        String scale[]=new String[7];//creating an array to store the 7 notes of the particular scale
        scale[0]=notes[rootIndex];//assigning the root note as the first element of scale
        int currentIndex=rootIndex;
        for (int i=1;i<7;i++)//i=1 here cuz the root is already at index 0 so we need to manage from index 1 onwards
        {
            currentIndex=(currentIndex+intervals[i-1])%12;// the  i-1 is done to satisfy the intervals;thus,this calculates the next note instead of the current note. The %12 is done to circle back to the first note 
            scale[i]=notes[currentIndex];
        }
         System.out.println(root+" Major Scale:");
         for(int i=0;i<scale.length;i++)
           System.out.print(scale[i]+"->");
        System.out.println("\nChords in the key of "+root+" are:");
        for(int i=0;i<scale.length;i++)
         System.out.print(scale[i]+" "+chordTypes[i]+"|");
        System.out.println("\nRelative minor:\n"+scale[5]+" minor");


       }



    }
}