package controller.command;

import model.Pixel;

/**
 * An interface that alters the state of an image.
 */
public interface ImageState extends ImageCommands {

  /**
   * Gives commands that will alter the state of the image.
   *
   * @param image a 2D array of pixels that make up the image.
   */
  void inputState(Pixel[][] image);

  /**
   * Outputs the new image after the changes have been made to the state.
   *
   * @return the new 2D array of pixels that represent the image with the state changes made.
   */
  Pixel[][] outputChanges();
}
