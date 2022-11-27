package controller.command;

import model.Pixel;

// Create a greyscale image with the red-component of the image with the given name,
// and refer to it henceforth in the program by the given destination name. Similar commands
// for green, blue, value, luma, intensity components should be supported.

/**
 * Has the commands which takes a pixel in the image and converts it into either one of the
 * component requested by the user.
 */
public class Greyscale implements ImageCommands {

  private final String greyscaleType;

  /**
   * the constructor which takes in the type of greyscale from the user which goes to the controller
   * to run the command.
   *
   * @param type which type of greyscale.
   */
  public Greyscale(String type) {
    this.greyscaleType = type;
  }

  /**
   * checks the given command for greyscale and then returns the command on the given pixel in the
   * image.
   *
   * @param pixel given pixel in the image
   * @return returns the command on the given pixel in the image.
   * @throws IllegalArgumentException if the given user input command is not one of the following
   */
  public Pixel commands(Pixel pixel) throws IllegalArgumentException {
    if (this.greyscaleType.equals("red-component")) {
      return this.redScale(pixel);
    }
    if (this.greyscaleType.equals("green-component")) {
      return this.greenScale(pixel);
    }
    if (this.greyscaleType.equals("blue-component")) {
      return this.blueScale(pixel);
    }
    if (this.greyscaleType.equals("value-component")) {
      return this.maxValue(pixel);
    }
    if (this.greyscaleType.equals("intensity-component")) {
      return this.intensity(pixel);
    }
    if (this.greyscaleType.equals("luma-component")) {
      return this.luma(pixel);
    } else {
      throw new IllegalArgumentException(this.greyscaleType + "is not a valid greyscale component");
    }
  }

  /**
   * makes all of the images have the same component value as the red component in the rgb.
   *
   * @param pixel the given pixel
   * @return the same value for each component
   */
  public Pixel redScale(Pixel pixel) {
    pixel.red(pixel.getRed());
    pixel.blue(pixel.getRed());
    pixel.green(pixel.getRed());
    return pixel;
  }

  /**
   * makes all of the images have the same component value as the green component in the rgb.
   *
   * @param pixel the given pixel
   * @return the same value for each component
   */
  public Pixel greenScale(Pixel pixel) {
    pixel.red(pixel.getGreen());
    pixel.blue(pixel.getGreen());
    pixel.green(pixel.getGreen());
    return pixel;
  }

  /**
   * makes all of the images have the same component value as the blue component in the rgb.
   *
   * @param pixel the given pixel
   * @return the same value for each component
   */
  public Pixel blueScale(Pixel pixel) {
    pixel.red(pixel.getBlue());
    pixel.blue(pixel.getBlue());
    pixel.green(pixel.getBlue());
    return pixel;
  }

  /**
   * makes all of the pixels have the max value between each of the rgb components of the pixel.
   *
   * @param pixel the given pixel
   * @return the same value for each component
   */
  public Pixel maxValue(Pixel pixel) {
    int maxValue = pixel.maxValue();
    pixel.red(maxValue);
    pixel.green(maxValue);
    pixel.blue(maxValue);
    return pixel;
  }

  /**
   * increases the intensity set to the average of all three components.
   *
   * @param pixel the given pixel
   * @return component average
   */
  public Pixel intensity(Pixel pixel) {
    int intensity = pixel.intensity();
    pixel.red(intensity);
    pixel.green(intensity);
    pixel.blue(intensity);
    return pixel;
  }

  /**
   * given sum and set the value to all components of the rgb.
   *
   * @param pixel the given pixel
   * @return the luma value to all compoentns
   */
  public Pixel luma(Pixel pixel) {
    double luma = pixel.luma();
    pixel.red((int) luma);
    pixel.green((int) luma);
    pixel.blue((int) luma);
    return pixel;
  }

  @Override
  public String commandName() {
    return "Greyscale";
  }
}
