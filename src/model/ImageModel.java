package model;

import java.io.IOException;

import controller.command.ImageCommands;
import controller.command.ImageState;

/**
 * Represents the interface for the image model.
 */
public interface ImageModel {

  /**
   * Gets the location of a pixel at the given row and col.
   *
   * @param row represents the row location of the pixel we want to get.
   * @param col represents the col location of the pixel we want to get.
   * @return a Pixel at the given row, col.
   */
  Pixel retrievePixel(int row, int col);

  /**
   * Loads an image into the model.
   *
   * @param path          the file path of the loaded image.
   * @param userImageName the name that the user provides for the image.
   * @throws IllegalArgumentException if the path or user image name does not exist
   */
  void processImage(String path, String userImageName) throws IllegalArgumentException;

  /**
   * Gets an image if it has been saved or is being loaded.
   *
   * @param userImageName uses the image name to get the image
   * @return a 2D array of pixels that represent the retrieved image.
   * @throws IllegalArgumentException if the image does not exist in storgae or is not
   *                                  properly loaded.
   */
  Pixel[][] retrieveImage(String userImageName) throws IllegalArgumentException;

  /**
   * Saves an image to a path.
   *
   * @param path          the path where the image saves.
   * @param userImageName the name of the image that is being saved.
   */
  void saveImage(String path, String userImageName);

  /**
   * Gets the total amount of rows present in an image.
   */
  int getRow();

  /**
   * Gets the total amount of columns present in an image.
   */
  int getCol();

  /**
   * retrieves the max value of the pixels in the given image.
   *
   * @param img given image name
   * @return an integer which is the max value
   */
  int retrieveMaxVal(String img);

  /**
   * The command which takes in the image with the given flip command, changes the state of the
   * given image.
   *
   * @param state       flip state they want
   * @param image       given image
   * @param destination the destination of the image after command
   * @throws IOException if the image is path, destination does not exist
   */
  void flipCommand(ImageState state, String image, String destination) throws IOException;

  /**
   * command given which is applied to a pixel.
   *
   * @param command     the command
   * @param image       the given image
   * @param destination the destination
   * @throws IOException if the image path or destination does not exist
   */
  void commandProcessor(ImageCommands command, String image, String destination) throws IOException;
}


