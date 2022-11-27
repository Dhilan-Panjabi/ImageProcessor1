package controller;

import org.junit.Test;


import java.io.StringReader;

import model.ImageModel;
import model.ImageModelImpl;
import view.ImageView;
import view.ImageViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * The controller test.
 */
public class ImageControllerImplTest {

  ImageController c1;
  StringReader in;
  StringBuilder out;
  ImageView view;
  ImageModel model;
  StringBuilder builder;
  StringReader reader;

  @Test
  public void InvalidController1() {
    this.model = new ImageModelImpl("rec/Koala.ppm", "Koala");
    this.out = new StringBuilder();
    this.view = new ImageViewImpl(this.model, out);
    this.in = new StringReader("");

    try {
      this.c1 = new ImageControllerImpl(null, null, null);
    } catch (IllegalArgumentException e) {
      assertEquals("please provide values for input, view, model", e.getMessage());
    }
  }

  @Test
  public void InvalidController2() {
    this.model = new ImageModelImpl("rec/Koala.ppm", "Koala");
    this.out = new StringBuilder();
    this.view = new ImageViewImpl(this.model, out);
    this.in = new StringReader("");

    try {
      this.c1 = new ImageControllerImpl(this.model, null, null);
    } catch (IllegalArgumentException e) {
      assertEquals("please provide values for input, view, model", e.getMessage());
    }
  }

  @Test
  public void InvalidController3() {
    this.model = new ImageModelImpl("rec/Koala.ppm", "Koala");
    this.out = new StringBuilder();
    this.view = new ImageViewImpl(this.model, out);
    this.in = new StringReader("");

    try {
      this.c1 = new ImageControllerImpl(null, this.view, null);
    } catch (IllegalArgumentException e) {
      assertEquals("please provide values for input, view, model", e.getMessage());
    }
  }

  @Test
  public void InvalidController4() {
    this.model = new ImageModelImpl("rec/Koala.ppm", "Koala");
    this.out = new StringBuilder();
    this.view = new ImageViewImpl(this.model, out);
    this.in = new StringReader("");

    try {
      this.c1 = new ImageControllerImpl(null, null, this.in);
    } catch (IllegalArgumentException e) {
      assertEquals("please provide values for input, view, model", e.getMessage());
    }
  }

  @Test
  public void testMessage() {
    this.model = new ImageModelImpl();
    this.out = new StringBuilder();
    this.view = new ImageViewImpl(this.model, out);
    this.in = new StringReader("load image rec/koala.ppm koala" +
            "red-component Koala.ppm rec/red-koala.ppm" +
            "quit");
    this.c1 = new ImageControllerImpl(this.model, this.view, this.in);
    this.c1.imageEditor();


    String instructions = "If you would like to upload an image " +
            "please provide type 'load IMAGE-PATH IMAGE-DESTINATION \n" +
            "Once the image is shown you can use commands such as 'brighten', 'darken', " +
            "'horizontal-flip', 'red-component', 'blue-component', 'value-component'," +
            " 'intensity-component', 'luma-component' \n" +
            "To save the edited image please enter 'save IMAGE-PATH IMAGE-DESTINATION" +
            "To quit the program please enter 'quit'";
    String[] outputArray2 = out.toString().split(System.lineSeparator());
    assertEquals("", outputArray2[0]);
  }

}

