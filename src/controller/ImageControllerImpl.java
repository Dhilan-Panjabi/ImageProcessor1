package controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

import controller.command.ImageStateImpl;
import controller.command.Lighting;
import controller.command.ImageCommands;
import model.ImageModel;
import view.ImageView;

/**
 * The controller implementation which takes in the commands from the user and runs them within the
 * program or quit the program.
 */
public class ImageControllerImpl implements ImageController {
  private final ImageModel model;

  private final Scanner input;
  //  private final ImageView view;
  private String imageName;
  private String destination;
  private final Map<String, Function<Scanner, ImageCommands>> inputCommands = new HashMap<>();

  /**
   * The controllers default constructor which takes in the model, view and input reader.
   *
   * @param model the model
   * @param view  the given image view
   */
  public ImageControllerImpl(ImageModel model, ImageView view) {
    this(model, view, new InputStreamReader(System.in));
  }


  /**
   * Constructor which takes in the input, model and view.
   *
   * @param model model
   * @param view  view
   * @param input given input
   */
  public ImageControllerImpl(ImageModel model, ImageView view, Readable input) {
    if (model == null) {
      throw new IllegalArgumentException("please provide values for input, view, model");
    }
    if (view == null) {
      throw new IllegalArgumentException("please provide values for input, view, model");
    }
    if (input == null) {
      throw new IllegalArgumentException("please provide values for input, view, model");
    }

    this.model = model;
    //    this.view = view;
    this.input = new Scanner(input);
    this.inputCommands.put("brighten", (s) -> {
      ImageCommands cmd = new Lighting(this.checkInt(s), "brighten");
      this.setDestination(s);
      return cmd;
    });
    this.inputCommands.put("darken", (s) -> {
      ImageCommands cmd = new Lighting(this.checkInt(s), "darken");
      this.setDestination(s);
      return cmd;
    });
    this.inputCommands.put(("horizontal-flip"), (s) -> {
      this.setDestination(s);
      return new ImageStateImpl("horizontal-flip");
    });
    this.inputCommands.put(("vertical-flip"), (s) -> {
      this.setDestination(s);
      return new ImageStateImpl("vertical-flip");
    });
    this.inputCommands.put(("red-component"), (s) -> {
      this.setDestination(s);
      return new ImageStateImpl("red-component");
    });
    this.inputCommands.put(("blue-component"), (s) -> {
      this.setDestination(s);
      return new ImageStateImpl("blue-component");
    });
    this.inputCommands.put(("green-component"), (s) -> {
      this.setDestination(s);
      return new ImageStateImpl("green-component");
    });
    this.inputCommands.put(("value-component"), (s) -> {
      this.setDestination(s);
      return new ImageStateImpl("value-component");
    });
    this.inputCommands.put(("intensity-component"), (s) -> {
      this.setDestination(s);
      return new ImageStateImpl("intensity-component");
    });
    this.inputCommands.put(("luma-component"), (s) -> {
      this.setDestination(s);
      return new ImageStateImpl("luma-component");
    });
  }

  private void setDestination(Scanner s) {
    destination = this.checkString(s);
    imageName = this.checkString(s);
  }

  private int checkInt(Scanner s) {
    try {
      return s.nextInt();
    } catch (NoSuchElementException ie) {
      throw new IllegalStateException("no command found");
    }
  }

  private String checkString(Scanner s) {
    try {
      return s.next();
    } catch (NoSuchElementException ie) {
      throw new IllegalStateException("no command found");
    }
  }


  @Override
  public void imageEditor() throws IllegalArgumentException {
    String userInput;

    String instructions = "If you would like to upload an image " +
            "please provide type 'load IMAGE-PATH IMAGE-DESTINATION \n" +
            "Once the image is shown you can use commands such as 'brighten', 'darken', " +
            "'horizontal-flip', 'red-component', 'blue-component', 'value-component'," +
            " 'intensity-component', 'luma-component' \n" +
            "To save the edited image please enter 'save IMAGE-PATH IMAGE-DESTINATION" +
            "To quit the program please enter 'quit'";
    System.out.println(instructions);

    while (input.hasNext()) {
      userInput = this.checkString(input);
      switch (userInput) {
        case "save image":
          this.setDestination(input);
          try {
            this.model.saveImage(imageName, destination);
          } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("cannot find image name or given destination");
          }
          break;
        case "load image":
          this.setDestination(input);
          try {
            this.model.processImage(imageName, destination);
          } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("cannot find image name or given destination");
          }
          break;
        case "quit":
          System.out.println("thank you for using the program");
          return;
        default:
          Function<Scanner, ImageCommands> commands = this.inputCommands.getOrDefault(userInput,
                  null);
          if (commands != null) {
            System.out.println("Unknown command " + userInput);
          } else {
            try {
              this.model.commandProcessor(commands.apply(input), destination, destination);
            } catch (IOException e) {
              System.out.println("fails");
            }
            break;
          }
      }
      throw new IllegalArgumentException("no more inputs");
    }

  }
}
