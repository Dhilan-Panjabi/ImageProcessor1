package controller.command;

import model.Pixel;

/**
 * The class which represents the change in lighting of the image, either brighten or darken the
 * given image and input from the user which is called to the controller.
 */
public class Lighting implements ImageCommands {
  // brighten the image by the given increment to create a new image,
  // referred to henceforth by the given destination name.
  // The increment may be positive (brightening) or negative (darkening)

  private final int incrementValue;

  private final String type;

  /**
   * The constructor takens in the increment value to brighten or darken the image and the type of
   * command they would like to do.
   *
   * @param incrementValue the value to increase the image lighting
   * @param type           the lighting command given by the user.
   * @throws IllegalArgumentException if the given value is more than 255 or less than 0
   */
  public Lighting(int incrementValue, String type) throws IllegalArgumentException {
    if (incrementValue > 255 || incrementValue < 0) {
      throw new IllegalArgumentException("Increment value must be in between 0-255");
    }
    this.incrementValue = incrementValue;
    this.type = type;
  }

  /**
   * check the given command whether the user input is to brighten or darken the image.
   *
   * @param pixel the given pixel to apply the command to
   * @return the increased or decreased pixel image
   * @throws IllegalArgumentException if the given command does not exist
   */
  public Pixel command(Pixel pixel) throws IllegalArgumentException {
    if (this.type.equals("brighten")) {
      return this.brightenPixel(pixel);
    }
    if (this.type.equals("darken")) {
      return this.darkenPixel(pixel);
    } else {
      throw new IllegalArgumentException("No greyscale of " + this.type);
    }
  }

  /**
   * the method to brighten the pixel.
   *
   * @param pixel takes in a pixel
   * @return a brightened pixel by the given increment
   */
  public Pixel brightenPixel(Pixel pixel) {
    if (this.incrementValue + pixel.getRed() > 0 && this.incrementValue + pixel.getRed() < 256) {
      pixel.red(pixel.getRed() + this.incrementValue);
    }
    if (this.incrementValue + pixel.getGreen() > 0
            && this.incrementValue + pixel.getGreen() < 256) {
      pixel.green(pixel.getGreen() + this.incrementValue);
    }
    if (this.incrementValue + pixel.getBlue() > 0 && this.incrementValue + pixel.getBlue() < 256) {
      pixel.blue(pixel.getBlue() + this.incrementValue);
    }
    return pixel;
  }

  /**
   * the method to darken the pixel.
   *
   * @param pixel takes in a pixel
   * @return a brightened pixel by the given increment
   */
  public Pixel darkenPixel(Pixel pixel) {
    if (pixel.getRed() - this.incrementValue > 0 && pixel.getRed() - this.incrementValue < 256) {
      pixel.red(pixel.getRed() - this.incrementValue);
    }
    if (pixel.getGreen() - this.incrementValue > 0
            && pixel.getGreen() - this.incrementValue < 256) {
      pixel.green(pixel.getGreen() - this.incrementValue);
    }
    if (pixel.getBlue() - this.incrementValue > 0
            && pixel.getBlue() - this.incrementValue < 256) {
      pixel.blue(pixel.getBlue() - this.incrementValue);
    }
    return pixel;
  }

  @Override
  public Pixel commands(Pixel pixel) {
    return pixel;
  }

  @Override
  public String commandName() {
    return "Lighting";
  }
}
