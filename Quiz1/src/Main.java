public class Main {

    public static void main (String[] args)
    {

        int[] numbers = {35, 69, 1, 10, -50, 320, 63, 58, 26, 13};

        System.out.println("Initial Unsorted Array");
        printArrayElements(numbers);


        int[] bubbleArray = copyArray(numbers);
        int[] selectionArray = copyArray(numbers);

        sortDescending(bubbleArray);
        selectionSortSmallestToEnd(selectionArray);

        System.out.println("Result of Bubble Sort (Descending)");
        printArrayElements(bubbleArray);


    }

    public static int[] copyArray(int[] original)
    {
        int[] copy = new int[original.length];
        // int "copy" turns into a new int with the same length as the last one

        for (int i = 0; i < original.length; i++)
        {
            copy[i] = original[i];
        }
        // legit just copies everything
        return copy;
    }

    private static void sortDescending(int[] arr)
    { // test value array of 3,1,2
        for (int lastIndex = arr.length - 1; lastIndex > 0; lastIndex--)
        { // example array of 3,1,2 LSI turns into 2 bcuz arr.length = 3 - 1 = 2 and array starts with 0
            // then checks if LSI is bigger than 0, if it is then pass to next loop after it will -1 so it turns into 1
            for (int i = 0; i < lastIndex; i++)
            { // I = 0, if its smaller than LSI then + 1, at test rn it is so it turns into 1 after passing to next loop, it wont be after
                if (arr[i] < arr[i + 1])
                { // I = 1 right now? so we compare 1 and 2 in the array which is 3 and 1
                    // int temp = array 1, so if temp array(value of 3) is < arr(value of 1) then
                    // tempt turns into arr and arr turns ito tempt
                    // it doesnt in the first one so it stays the same and now i in the loop before this is 1
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    private static void selectionSortSmallestToEnd(int[] arr)
    {
        for (int lastIndex = arr.length - 1; lastIndex > 0; lastIndex--)
        {
            int smallestIndex = 0;
            for (int i = 1; i <= lastIndex; i++)
            {
                if (arr[i] < arr[smallestIndex])
                {
                    smallestIndex = i;
                }
            }
            int temp = arr[lastIndex];
            arr[lastIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    private static void printArrayElements(int[] arr)
    {
        for (int j : arr)
        {
            System.out.println(j + " ");
        }
    }
}
