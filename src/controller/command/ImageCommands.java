package controller.command;

import model.Pixel;

/**
 * The image commands interface.
 */
public interface ImageCommands {
  /**
   * the commands in which they get operations called on the pixels.
   *
   * @param p the pixel
   * @return the command done on the pixel
   */
  Pixel commands(Pixel p);

  /**
   * The general command name which is checked.
   *
   * @return command name
   */
  String commandName();
}
