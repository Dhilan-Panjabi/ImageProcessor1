package command;

import org.junit.Before;
import org.junit.Test;

import controller.command.ImageState;
import controller.command.ImageStateImpl;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * The state test which checks whether the image can be flipped by the given commands.
 */
public class ImageStateImplTest {
  Pixel[][] image1;
  ImageState horizontalFlip;
  ImageState verticalFlip;

  @Before
  public void init() {
    image1 = new Pixel[][]{new Pixel[]{new Pixel(5, 6, 7),
        new Pixel(8, 8, 8)},
        new Pixel[]{new Pixel(15, 14, 16), new Pixel(19, 20, 30),}};

    horizontalFlip = new ImageStateImpl("horizontal-flip");
    verticalFlip = new ImageStateImpl("vertical-flip");
  }

  @Test
  public void testHorizontalFlip() {
    this.horizontalFlip.inputState(image1);
    Pixel[][] hFlip1 = this.horizontalFlip.outputChanges();
    assertEquals("r: 8,g: 8,b: 8", hFlip1[0][0].toString());
    assertEquals("r: 5,g: 6,b: 7", hFlip1[0][1].toString());
    assertEquals("r: 19,g: 20,b: 30", hFlip1[1][0].toString());
    assertEquals("r: 15,g: 14,b: 16", hFlip1[1][1].toString());
  }

  @Test
  public void testVerticalFLip() {
    this.verticalFlip.inputState(image1);
    Pixel[][] vFlip1 = this.verticalFlip.outputChanges();
    assertEquals("r: 15,g: 14,b: 16", vFlip1[0][0].toString());
    assertEquals("r: 19,g: 20,b: 30", vFlip1[0][1].toString());
    assertEquals("r: 5,g: 6,b: 7", vFlip1[1][0].toString());
    assertEquals("r: 8,g: 8,b: 8", vFlip1[1][1].toString());
  }

  @Test
  public void testInvalidFlips() {
    horizontalFlip = new ImageStateImpl("haha-flip");
    verticalFlip = new ImageStateImpl("nono-flip");

    this.horizontalFlip.inputState(image1);
    this.verticalFlip.inputState(image1);

    try {
      Pixel[][] horizontalFlip = this.horizontalFlip.outputChanges();
    } catch (IllegalArgumentException e) {
      assertEquals("haha-flip is not a valid command", e.getMessage());
    }

    try {
      Pixel[][] verticalFlip = this.verticalFlip.outputChanges();
    } catch (IllegalArgumentException e) {
      assertEquals("nono-flip is not a valid command", e.getMessage());
    }
  }

}