package com.hackerrank.interview.sorting;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;

/*
Function Description

Declare a Checker class that implements the comparator method as described. It should sort first descending by score, then ascending by name. The code stub reads the input, creates a list of Player objects, uses your method to sort the data, and prints it out properly.

Input Format

Locked stub code in the Solution class handles the following input from stdin:

The first line contains an integer, n, the number of players.
Each of the next n lines contains a player's respective name and score, a string and an integer.

https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
*/
class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.score > o2.score) return -1;
        else if (o1.score < o2.score) return 1;
        return o1.name.compareTo(o2.name);
    }
}


public class SortingComparator {

    @Test
    public void checkOrdinating() {
        Checker checker = new Checker();

        Player[] playersUnordered1 = {new Player("amy", 100), new Player("david", 100), new Player("heraldo", 50), new Player("aakansha", 75), new Player("aleksa", 150)};
        Player[] playersOrdered1 = {new Player("aleksa", 150), new Player("amy", 100), new Player("david", 100), new Player("aakansha", 75), new Player("heraldo", 50)};
        Player[] playersUnordered2 = {new Player("smith", 20), new Player("jones", 15), new Player("jones", 20)};
        Player[] playersOrdered2 = {new Player("jones", 20), new Player("smith", 20), new Player("jones", 15)};

        Arrays.sort(playersUnordered1, checker);
        Arrays.sort(playersUnordered2, checker);
        Assert.assertThat(playersOrdered1, is(playersUnordered1));
        Assert.assertThat(playersOrdered2, is(playersUnordered2));
    }

}
