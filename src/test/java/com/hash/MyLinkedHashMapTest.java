package com.hash;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedHashMapTest {
    @Test
    public void givenASentenceWhenWordsAreAddedToListShouldReturnWordFrequency() {
        String sentence = "Paranoid are not paranoid because they are paranoid " +
                "because they keep putting themselves deliberately into" +
                "paranoid avoidable situation";
        MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myLinkedHashMap.get(word);
            if (value == null) value = 1;
            else value = value + 1;
            myLinkedHashMap.add(word, value);
        }
        System.out.println(myLinkedHashMap);
        int frequency = myLinkedHashMap.get("paranoid");
        Assert.assertEquals(3, frequency);
    }

    @Test
    public void givenASentence_WhenAWordIsGiven_ShouldDeleteTheWord() {
        String sentence = "Paranoid are not paranoid because they are paranoid " +
                "because they keep putting themselves deliberately into" +
                "paranoid avoidable situation";
        MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            Integer value = myLinkedHashMap.get(word);
            if (value == null) {
                value = 1;
            } else {
                value += 1;
            }
            myLinkedHashMap.add(word, value);
        }
        boolean result = myLinkedHashMap.delete("avoidable");
        System.out.println("My linked list after deleting is : " + myLinkedHashMap);
        Assert.assertTrue(result);
    }
}
