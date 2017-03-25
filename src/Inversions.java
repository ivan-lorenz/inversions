import java.util.*;

public class Inversions {

    public static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);

        numberOfInversions += merge(a,b,left,ave,right);

        return numberOfInversions;
    }

    private static long merge(int[] a, int[] b, int left, int ave, int right) {
        int d[] = new int[right - left];
        int i = left;
        int j = ave;
        int count = 0;
        int numberOfInversions = 0;
        while (i < ave && j < right) {
            if (a[i] <= a[j])
                d[count] = a[i++];
            else {
                d[count] = a[j++];
                numberOfInversions += ave - i;
            }
            count++;
        }
        while (i < ave)
            d[count++] = a[i++];
        while(j < right)
            d[count++] = a[j++];

        for(int c = 0; c < right - left;c++)
            a[left+c] = d[c];

        return numberOfInversions;
    }

    public static long getNumberOfInversionsNaive(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;

        for(int i = left; i < right; i++) {
            for (int j = i+ 1; j < right; j++) {
                if (a[i] > a[j])
                    numberOfInversions++;
            }
        }
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

