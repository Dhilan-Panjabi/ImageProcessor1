package model;

/**
 * A class which represents a single pixel which has the red, green, blue component of the pixel.
 */
public class Pixel {

  private int red;

  private int green;

  private int blue;

  /**
   * the constructor for the pixel.
   *
   * @param red   red component
   * @param green green component
   * @param blue  blue component
   * @throws IllegalArgumentException if they are bigger than the allowed values.
   */
  public Pixel(int red, int green, int blue) throws IllegalArgumentException {
    if (red > 255 || green > 255 || blue > 255
            || red < 0 || green < 0 || blue < 0) {
      throw new IllegalArgumentException("Pixels must have values within the 0-255 range");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * sets the red value to a value in between the given parameters.
   *
   * @param red which is the value of red
   * @throws IllegalArgumentException if the value is not in those parameters
   */
  public void red(int red) throws IllegalArgumentException {
    if (red > 255 || red < 0) {
      throw new IllegalArgumentException("Invalid set position");
    }
    this.red = red;
  }

  /**
   * sets the green value to a value in between the given parameters.
   *
   * @param green which is the value of red
   * @throws IllegalArgumentException if the value is not in those parameters
   */
  public void green(int green) throws IllegalArgumentException {
    if (green > 255 || green < 0) {
      throw new IllegalArgumentException("Invalid set position");
    }
    this.green = green;
  }

  /**
   * sets the blue value to a value in between the given parameters.
   *
   * @param blue which is the value of red
   * @throws IllegalArgumentException if the value is not in those parameters
   */
  public void blue(int blue) throws IllegalArgumentException {
    if (blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Invalid set position");
    }
    this.blue = blue;
  }

  // the maximum value of the three components for each pixel
  public int maxValue() {
    return Math.max(Math.max(this.red, this.green), this.blue);
  }

  // the average of the three components for each pixel
  public int intensity() {
    return ((this.red + this.green + this.blue) / 3);
  }

  public int luma() {
    return (int) ((0.2126 * (this.red)) + (0.7152 * (this.green)) + (0.0722 * (this.blue)));
  }

  //makes a copy
  public Pixel clip() {
    return new Pixel(this.red, this.green, this.blue);
  }

  public int getRed() {
    return this.red;
  }

  public int getGreen() {
    return this.green;
  }

  public int getBlue() {
    return this.blue;
  }

  public String toString() {
    return "r: " + this.red + ",g: " + this.green + ",b: " + this.blue;
  }

}
