package com.company.designpattern;

class Phone {
  private boolean isNfcEnabled;
  private boolean isAmoledScreen;
  private boolean isAudioJackPresent;

  private Phone(PhoneBuilder phoneBuilder) {
    this.isAmoledScreen = phoneBuilder.isAmoledScreen;
    this.isAudioJackPresent = phoneBuilder.isAudioJackPresent;
    this.isNfcEnabled = phoneBuilder.isNfcEnabled;
  }

  public boolean isNfcEnabled() {
    return isNfcEnabled;
  }

  public boolean isAmoledScreen() {
    return isAmoledScreen;
  }

  public boolean isAudioJackPresent() {
    return isAudioJackPresent;
  }

  static class PhoneBuilder {
    private boolean isNfcEnabled;
    private boolean isAmoledScreen;
    private boolean isAudioJackPresent;

    public PhoneBuilder() {
    }

    public PhoneBuilder setNfcEnabled(boolean nfcEnabled) {
      this.isNfcEnabled = nfcEnabled;
      return this;
    }

    public PhoneBuilder setAmoledScreen(boolean amoledScreen) {
      this.isAmoledScreen = amoledScreen;
      return this;
    }

    public PhoneBuilder setAudioJackPresent(boolean audioJackPresent) {
      this.isAudioJackPresent = audioJackPresent;
      return this;
    }

    public Phone build() {
      return new Phone(this);
    }
  }

  @Override
  public String toString() {
    return "Phone{" +
        "isNfcEnabled=" + isNfcEnabled +
        ", isAmoledScreen=" + isAmoledScreen +
        ", isAudioJackPresent=" + isAudioJackPresent +
        '}';
  }
}

public class BuilderPattern {
  public static void main(String[] args) {
    Phone phone = new Phone.PhoneBuilder()
        .setNfcEnabled(false)
        .setAmoledScreen(true)
        .setAudioJackPresent(true)
        .build();
    System.out.println(phone);
  }
}
