public class Main {
    public static void main(String[] args) {
        int[] array = new int [] {2, 3, 6, 1, 8, 4, 55, 4, 45, 7, 2, 6, 9, 34, 56, 33,0, 1, 6, 45};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        long startTime = System.currentTimeMillis();
        sort(array);
        long endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения сортировки: %d мс.\n", endTime - startTime);
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void sort(int[] array){
        //Построение кучи (Перегрупируем массив)
        for(int i = array.length / 2 - 1; i >= 0; i--){
            heapify(array, array.length, i);
        }

        //Извлекаем элементы из кучи
        for(int i = array.length - 1; i >= 0; i--){
            //Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex; // Иниуиаизируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // Если левый дочерний элемент больше корня
        if(leftChild < heapSize && array[leftChild] > array[largest]){
            largest = leftChild;
        }

        // Есди правый дочерний элемент больше, чем самый большой элемент на данный момент
        if(rightChild < heapSize && array[rightChild] > array[largest]){
            largest = rightChild;
        }

        // Если самый большой элемент не корень
        if(largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            //Рекурсивно преобразуем в двоичную кучу затронутоеп поддерево
            heapify(array, heapSize, largest);
        }
    }
}
