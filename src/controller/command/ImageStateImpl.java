package controller.command;

import model.Pixel;

/**
 * The class which represents the orientation of the image, this holds the commands of horizontal-
 * flip, vertical-flip and implements them if called.
 */
public class ImageStateImpl implements ImageState {

  private final String flipType;

  private Pixel[][] in;

  private Pixel[][] out;

  private Pixel[][] image;

  private int row;

  private int col;

  /**
   * given the type of flip the user inputs.
   *
   * @param flipType given flip type.
   */
  public ImageStateImpl(String flipType) {
    this.flipType = flipType;
  }

  @Override
  public void inputState(Pixel[][] image) throws IllegalArgumentException {
    if (image != null) {
      this.row = image.length;
      this.col = image.length;
      this.in = image;
      this.out = new Pixel[row][col];
    } else {
      throw new IllegalArgumentException("No image present");
    }
  }

  @Override
  public Pixel[][] outputChanges() {
    if (this.flipType.equals("horizontal-flip")) {
      return horizontalFlip();
    }
    if (this.flipType.equals("vertical-flip")) {
      return verticalFlip();
    } else {
      throw new IllegalArgumentException(this.flipType + " is not a valid command");
    }
  }

  private Pixel[][] verticalFlip() {
    int width = this.col;
    int height = this.row;

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        this.out[this.row - 1 - row][col] = this.in[row][col].clip();

      }
    }
    return this.out;
  }

  private Pixel[][] horizontalFlip() {
    int width = this.col;
    int height = this.row;

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        this.out[row][this.col - 1 - col] = this.in[row][col].clip();
      }
    }
    return this.out;
  }

  @Override
  public Pixel commands(Pixel pixel) {
    return pixel;
  }

  @Override
  public String commandName() {
    return "State";
  }
}