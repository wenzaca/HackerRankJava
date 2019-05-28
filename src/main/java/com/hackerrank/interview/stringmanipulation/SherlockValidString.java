package com.hackerrank.interview.stringmanipulation;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;

/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters will occur the same number of times. Given a string s, determine if it is valid. If so, return YES, otherwise return NO.
 */
public class SherlockValidString {
    // Complete the isValid function below.
    static String isValid(String s) {

        if (s == null) return "NO";
        if (s.isEmpty()) return "YES";

        String alphabeth = "abcdefghijklmnopqrstuvxwyz";

        Map<Integer, String> map = new HashMap<>(s.length());

        for (Character charAlphabeth : alphabeth.toCharArray()) {
            java.util.regex.Matcher m = Pattern.compile(charAlphabeth.toString()).matcher(s);

            int matches = 0;
            while (m.find())
                matches++;
            if (matches > 0) {
                map.computeIfPresent(matches, (key, value) -> {
                    return map.get(key) + charAlphabeth;
                });
                map.putIfAbsent(matches, charAlphabeth.toString());
            }
        }
        Integer lenght1 = 0, lenght2 = 0;

        if (map.size() > 2) return "NO";
        if (map.size() < 2) return "YES";
        Map.Entry<Integer, String> entry1 = null;
        Map.Entry<Integer, String> entry2 = null;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry1 == null) {
                entry1 = entry;
                continue;
            }
            if (entry1.getKey() < entry.getKey()) {
                entry2 = entry1;
                entry1 = entry;
            }
        }
        if (entry1.getKey() - entry2.getKey() > 1 && !(entry2.getKey() == 1 && entry2.getValue().length() == 1))
            return "NO";
        if (entry2.getKey() == 1 && entry2.getValue().length() > 1 && entry1.getKey() != entry2.getKey() + 1)
            return "NO";
        if (entry2.getValue().length() > 1 && entry1.getValue().length() > 1) return "NO";
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        String result = isValid(s);


        scanner.close();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(SherlockValidString.isValid("aaaabbcc"), is("YES"));
        Assert.assertThat(SherlockValidString.isValid("aabbccddeefghi"), is("NO"));
        Assert.assertThat(SherlockValidString.isValid("aaaabc"), is("NO"));
        Assert.assertThat(SherlockValidString.isValid("aabbcd"), is("NO"));
        Assert.assertThat(SherlockValidString.isValid("abcc"), is("YES"));
        Assert.assertThat(SherlockValidString.isValid(null), is("NO"));
        Assert.assertThat(SherlockValidString.isValid(""), is("YES"));
        String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        Assert.assertThat(SherlockValidString.isValid(s), is("YES"));
    }
}
