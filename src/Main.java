import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{6, 6, 3, 4, 5, 1, 1, 1, 623, 325, 8, 8, 8, 8, 8, 8,};
        float counter;
        boolean isDuplicate;
        Iterator<Float> iter;
        HashMap<Float, Integer> map = new HashMap<>();
        ArrayList<Integer> uniqueValues = new ArrayList<>(); // ник значения
        ArrayList<Float> sequence = new ArrayList<>(); // последовательность
        uniqueValues.add(array[0]);


        for(int i = 0; i<array.length; i++){ // ищет уникальные значения которые не повторяются (6,3,4,5,1,623,8)
            isDuplicate = false;
            for(int j = 0; j<uniqueValues.size(); j++){
                if(array[i] == uniqueValues.get(j)){
                    isDuplicate = true; // если тру, то числа дублируются, значит мы не добавляем число
                }

            }
            if(!isDuplicate) { // если нету дубликатов добавляем в массив
                uniqueValues.add(array[i]);
            }
        }

        for (int j = 0; j<uniqueValues.size(); j++){ // поиск количества чисел
            counter = 0;
            for(int i = 0; i<array.length; i++){
                if(array[i]==uniqueValues.get(j)){
                    counter++;
                }
            }
            iter = map.keySet().iterator();
            while (iter.hasNext()){
                if(iter.next() == counter){
                    counter -= 0.000001; // нужен чтоб все хорошо работало
                }
            }
            map.put(counter, uniqueValues.get(j)); // добавяем в массив hashmap числа и ключи(counter)
        }
        iter = map.keySet().iterator(); // итератор нужен для перебирания массива

        while (iter.hasNext()){
            sequence.add(iter.next()); // добавляет всё в массив
        }
        Collections.sort(sequence); // сортируем массивы


        for (int j = sequence.size()-1; j>=0;j--) { // выводим отсортированный массив по частоте в консоль
            for(int i = 0;i<Math.round(sequence.get(j));i++){
                System.out.print(map.get( + sequence.get(j))+ " ");
            }
        }
    }
}