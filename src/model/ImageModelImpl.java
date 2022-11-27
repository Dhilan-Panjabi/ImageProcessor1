package model;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import controller.command.ImageCommands;
import controller.command.ImageState;

/**
 * The model class which represents the process of the image editor which they can save and do a
 * process on the image.
 */
public class ImageModelImpl implements ImageModel {

  private String userImageName;

  private int row;

  private int col;

  private int maxValue;

  private Pixel[][] pixels;

  private final Map<String, Pixel[][]> savedImage;

  /**
   * The default constructor which creates an empty Image Model Processor which is empty till the
   * user uploads loads an image.
   */
  public ImageModelImpl() {
    savedImage = new HashMap<>();
  }

  /**
   * Constructor that loads the given image with the given name.
   *
   * @param imagePath      the string path where the image is.
   * @param modelImageName the name of the image which it can be found at
   * @throws IllegalArgumentException if the path or name is not given.
   */
  public ImageModelImpl(String imagePath, String modelImageName) throws IllegalArgumentException {
    if (imagePath == null || modelImageName == null) {
      throw new IllegalArgumentException("Image path and image name needed");
    }
    this.savedImage = new HashMap<>();
    this.processImage(imagePath, modelImageName);
  }


  @Override
  public Pixel retrievePixel(int row, int col) {
    return this.pixels[row][col];
  }

  @Override
  public void processImage(String imagePath, String imageName) throws IllegalArgumentException {
    if (imagePath == null && imageName == null) {
      throw new IllegalArgumentException("image path and image name cannot be null");
    }
    if (imagePath == null) {
      throw new IllegalArgumentException("image path cannot be null");
    }
    if (imageName == null) {
      throw new IllegalArgumentException("the image name cannot be null");
    }

    Scanner fileScan;
    try {
      fileScan = new Scanner(new FileInputStream(imagePath));
      this.userImageName = imageName;
    } catch (FileNotFoundException f) {
      throw new IllegalArgumentException("given file name " + imageName + " cannot be found");
    }

    StringBuilder content = new StringBuilder();
    while (fileScan.hasNextLine()) {
      String s = fileScan.nextLine();
      if (s.charAt(0) != '#') {
        content.append(s);
        content.append(System.lineSeparator());
      }
    }
    fileScan = new Scanner(content.toString());

    String t;

    t = fileScan.next();
    if (!t.equals("P3")) {
      System.out.println("Invalid ppm file");
      return;
    }
    this.col = fileScan.nextInt();
    this.row = fileScan.nextInt();
    this.maxValue = fileScan.nextInt();
    this.pixels = new Pixel[row][col];
    Pixel[][] givenPixels = new Pixel[row][col];
    for (int row = 0; row < this.row; row = row + 1) {
      for (int col = 0; col < this.col; col = col + 1) {
        int red = fileScan.nextInt();
        int green = fileScan.nextInt();
        int blue = fileScan.nextInt();
        this.pixels[row][col] = new Pixel(red, green, blue);
        givenPixels[row][col] = new Pixel(red, green, blue);
      }
    }
    this.savedImage.put(this.userImageName, givenPixels);
  }

  @Override
  public Pixel[][] retrieveImage(String fileName) throws IllegalArgumentException {
    if (fileName.equals(this.userImageName)) {
      return this.pixels;
    } else {
      for (Map.Entry<String, Pixel[][]> e : this.savedImage.entrySet()) {
        if (e.getKey().equals(fileName)) {
          return savedImage.get(fileName);
        }
      }
    }
    throw new IllegalArgumentException("there is no image with " + fileName);
  }

  @Override
  public void saveImage(String path, String userImageName) {
    Pixel[][] imageStore = this.retrieveImage(userImageName);
    try {
      DataOutputStream output = new DataOutputStream(new FileOutputStream(path));
      String data = "P3" + System.lineSeparator() + this.col + " " + this.row +
              System.lineSeparator() + this.retrieveMaxVal(userImageName) + System.lineSeparator();
      output.write(data.getBytes(StandardCharsets.UTF_8));
      for (int row = 0; row < this.row; row = row + 1) {
        for (int col = 0; col < this.col; col = col + 1) {
          Pixel pixel = imageStore[row][col].clip();
          output.write((pixel.getRed() + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
          output.write((pixel.getGreen() + System.lineSeparator()).
                  getBytes(StandardCharsets.UTF_8));
          output.write((pixel.getBlue() + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
        }
      }
      output.close();
    } catch (IOException e) {
      System.out.println("unable to save image because the path or image name cannot be found");
    }

  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getCol() {
    return this.col;
  }

  @Override
  public int retrieveMaxVal(String img) {
    if (img.equals(this.userImageName)) {
      return this.maxValue;
    } else {
      int currMax = 0;
      Pixel[][] imgPixels = this.retrieveImage(img);
      for (int row = 0; row < this.row; row = row + 1) {
        for (int col = 0; col < this.col; col = col + 1) {
          int maxValue = imgPixels[row][col].maxValue();
          if (maxValue > currMax) {
            currMax = maxValue;
          }
        }
      }
      return currMax;
    }
  }

  /**
   * command given which is applied to a pixel.
   *
   * @param command     the command
   * @param image       the given image
   * @param destination the destination
   * @throws IOException if the image path or destination does not exist
   */
  public void commandProcessor(ImageCommands command, String image, String destination) {
    if (command.commandName().equals("State")) {
      this.flipCommand((ImageState) command, image, destination);
    } else {
      Pixel[][] img = new Pixel[getCol()][getRow()];
      for (int row = 0; row < this.row; row = row + 1) {
        for (int col = 0; col < this.col; col = col + 1) {
          img[row][col] = command.commands(this.pixels[row][col].clip());
        }
      }
      this.savedImage.put(destination, img);
    }
  }

  public void flipCommand(ImageState state, String image, String destination) {
    state.inputState(this.retrieveImage(image));
    this.savedImage.put(destination, state.outputChanges());
  }
}
