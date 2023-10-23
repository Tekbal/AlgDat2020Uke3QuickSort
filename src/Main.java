import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        int[] arr1 = {12, 18, 3, 65, 21, 17, 89};


        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


        insertionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }


        System.out.println();

        mergeSort(arr1, 0, arr1.length - 1);
        for (int num : arr1) {
            System.out.print(num + " ");
        }


    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;


        }
    }


    public static void mergeSort(int[] arr1, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // Diziyi ikiye bölmek için orta noktayı bul


            mergeSort(arr1, left, mid); // Sol yarımı sırala
            mergeSort(arr1, mid + 1, right); // Sağ yarımı sırala
            merge(arr1, left, mid, right); // İki yarımı birleştir
        }
    }

    public static void merge(int[] arr1, int left, int mid, int right) {
        int n1 = mid - left + 1; // Sol yarımın boyutunu hesapla
        int n2 = right - mid; // Sağ yarımın boyutunu hesapla

        int[] L = new int[n1]; // Sol yarım için geçici dizi oluştur
        int[] R = new int[n2]; // Sağ yarım için geçici dizi oluştur

        for (int i = 0; i < n1; ++i) {
            L[i] = arr1[left + i]; // Sol yarımı geçici diziye kopyala
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr1[mid + 1 + j]; // Sağ yarımı geçici diziye kopyala
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) { // Her iki yarımdaki elemanları birleştir
            if (L[i] <= R[j]) {
                arr1[k] = L[i];
                i++;
            } else {
                arr1[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) { // Sol yarımdaki kalan elemanları ekle
            arr1[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) { // Sağ yarımdaki kalan elemanları ekle
            arr1[k] = R[j];
            j++;
            k++;
        }
    }
}