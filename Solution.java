import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Initialize a Frequency Map
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Step 2: Populate Frequency Map
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 3: Create a List from the Frequency Map
        List<Map.Entry<String, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());

        // Step 4: Sort the List
        frequencyList.sort((entry1, entry2) -> {
            if (!entry1.getValue().equals(entry2.getValue())) {
                return entry2.getValue().compareTo(entry1.getValue()); // Descending order of frequency
            } else {
                return entry1.getKey().compareTo(entry2.getKey()); // Lexicographical order
            }
        });

        // Step 5: Select the Top K Words
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(frequencyList.get(i).getKey());
        }

        // Step 6: Return the Result
        return result;
    }
}
