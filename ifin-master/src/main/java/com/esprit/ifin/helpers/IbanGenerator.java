package com.esprit.ifin.helpers;

import java.util.Random;

public class IbanGenerator {
  public static String calculateIBAN() {
    final Random rand = new Random();
    final StringBuilder card = new StringBuilder("TN");
    for (int i = 0; i < 14; i++) {
      final int n = rand.nextInt(10);
      card.append(n);
    }
    return card.toString();
  }
}
