import java.util.*;

class Solution 
{
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) 
    {
        Map<Integer, int[]> map = new HashMap<>();

        // Store reserved seats for each row.
        for(int[] seat : reservedSeats)
        {
            int row = seat[0];
            int col = seat[1];

            if(!map.containsKey(row))
            {
                map.put(row, new int[11]);
            }

            map.get(row)[col] = 1;
        }

        int total = 0;

        // Rows with no reservations can always fit 2 families.
        total += (n - map.size()) * 2;

        // Process rows having reservations.
        for(int[] pos : map.values())
        {
            boolean left = true;
            boolean middle = true;
            boolean right = true;

            // Seats 2,3,4,5
            for(int i = 2; i <= 5; i++)
            {
                if(pos[i] == 1)
                {
                    left = false;
                    break;
                }
            }

            // Seats 4,5,6,7
            for(int i = 4; i <= 7; i++)
            {
                if(pos[i] == 1)
                {
                    middle = false;
                    break;
                }
            }

            // Seats 6,7,8,9
            for(int i = 6; i <= 9; i++)
            {
                if(pos[i] == 1)
                {
                    right = false;
                    break;
                }
            }

            // Left and right don't overlap,
            // so both families can sit.
            if(left && right)
            {
                total += 2;
            }
            // Otherwise, if ANY one block is available,
            // one family can sit.
            else if(left || middle || right)
            {
                total += 1;
            }
        }

        return total;
    }
}