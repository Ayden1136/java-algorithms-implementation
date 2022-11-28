package com.jwetherell.algorithms.data_structures.test;

import org.junit.Assert;
import org.junit.Test;

import com.jwetherell.algorithms.data_structures.SuffixTrie;
import com.jwetherell.algorithms.data_structures.test.common.SuffixTreeTest;

import static org.junit.Assert.*;

public class SuffixTrieTest {

    @Test
    public void testSuffixTrie() {
        String bookkeeper = "bookkeeper";
        SuffixTrie<String> trie = new SuffixTrie<String>(bookkeeper);
        assertTrue(SuffixTreeTest.suffixTreeTest(trie, bookkeeper));
    }
    @Test
    public void testAdd() {
        String bookkeeper = "bookkeeperS";
        SuffixTrie<String> trie = new SuffixTrie<String>(bookkeeper);
        String addedStr = "S";
        trie.add(addedStr);
        assertTrue(SuffixTreeTest.suffixTreeTest(trie, bookkeeper));
    }
    @Test
    public void testToString() {
        String bookkeeper = "bookkeeper";
        String emptyStr = "";
        SuffixTrie<String> trie1 = new SuffixTrie<String>(bookkeeper);
        SuffixTrie<String> trie2 = new SuffixTrie<String>(emptyStr);
        Assert.assertNotNull(trie1.toString());
        Assert.assertEquals(trie2.toString(),"Tree has no nodes.");
    }
    @Test
    public void testGetSuffixes() {
        String bookkeeper = "AydenZhu";
        SuffixTrie<String> trie = new SuffixTrie<String>(bookkeeper);
        assertNotNull(trie.getSuffixes());
        //assertEquals(, "[AydenZhu, Zhu, denZhu, enZhu, hu, nZhu, u, ydenZhu]");
    }
    @Test
    public void testDoesSubStringExist() {
        String bookkeeper = "AydenZhu";
        SuffixTrie<String> trie = new SuffixTrie<String>(bookkeeper);
        assertTrue(trie.doesSubStringExist("hu"));
        assertFalse(trie.doesSubStringExist("DAD"));
    }
}
