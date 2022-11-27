package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Represents the class for the pixel test.
 */
public class PixelTest {

  Pixel pixel1;

  Pixel pixel2;

  Pixel pixel3;

  Pixel pixel4;

  Pixel pixel5;

  @Before
  public void init() {

    this.pixel1 = new Pixel(0, 0, 0);

    this.pixel2 = new Pixel(239, 31, 31);

    this.pixel3 = new Pixel(31, 44, 239);

    this.pixel4 = new Pixel(31, 239, 86);

    this.pixel5 = new Pixel(255, 255, 255);
  }

  @Test
  public void invalidPixel1() {
    try {
      Pixel p = new Pixel(300, 20, 30);
      fail("Pixels must have values within the 0-255 range");
    } catch (IllegalArgumentException e) {
      //fail
    }
  }

  @Test
  public void invalidPixel2() {
    try {
      Pixel p = new Pixel(20, 300, 30);
      fail("Pixels must have values within the 0-255 range");
    } catch (IllegalArgumentException e) {
      //fail
    }
  }

  @Test
  public void invalidPixel3() {
    try {
      Pixel p = new Pixel(20, 30, 300);
      fail("Pixels must have values within the 0-255 range");
    } catch (IllegalArgumentException e) {
      //fail
    }
  }

  @Test
  public void invalidPixel4() {
    try {
      Pixel p = new Pixel(-20, 30, 300);
      fail("Pixels must have values within the 0-255 range");
    } catch (IllegalArgumentException e) {
      //fail
    }
  }

  @Test
  public void invalidPixel5() {
    try {
      Pixel p = new Pixel(20, -30, 300);
      fail("Pixels must have values within the 0-255 range");
    } catch (IllegalArgumentException e) {
      //fail
    }
  }

  @Test
  public void invalidPixel6() {
    try {
      Pixel p = new Pixel(20, 30, -300);
      fail("Pixels must have values within the 0-255 range");
    } catch (IllegalArgumentException e) {
      //fail
    }
  }

  @Test
  public void invalidPixel7() {
    try {
      Pixel p = new Pixel(300, 300, 300);
      fail("Pixels must have values within the 0-255 range");
    } catch (IllegalArgumentException e) {
      //fail
    }
  }

  @Test
  public void invalidPixel8() {
    try {
      Pixel p = new Pixel(-300, -300, -300);
      fail("Pixels must have values within the 0-255 range");
    } catch (IllegalArgumentException e) {
      //fail
    }
  }


  @Test
  public void clipTester1() {
    this.pixel1.red(50);
    this.pixel1.green(60);
    this.pixel1.blue(70);
    this.pixel2 = this.pixel1.clip();

    assertEquals(this.pixel2.getRed(), this.pixel1.getRed());
    assertEquals(this.pixel2.getGreen(), this.pixel1.getGreen());
    assertEquals(this.pixel2.getBlue(), this.pixel1.getBlue());

  }

  @Test
  public void clipTester2() {
    this.pixel1.red(50);
    this.pixel1.green(60);
    this.pixel1.blue(70);
    this.pixel2 = this.pixel1.clip();

    assertEquals(50, this.pixel2.getRed());
    assertEquals(60, this.pixel2.getGreen());
    assertEquals(70, this.pixel2.getBlue());
  }


  @Test
  public void Red() {
    this.pixel1.red(50);
    assertEquals(50, this.pixel1.getRed());


    this.pixel2.red(230);
    assertEquals(230, this.pixel2.getRed());


    this.pixel3.red(10);
    assertEquals(10, this.pixel3.getRed());

  }

  @Test
  public void Green() {
    this.pixel1.green(60);
    assertEquals(60, this.pixel1.getGreen());


    this.pixel2.green(220);
    assertEquals(220, this.pixel2.getGreen());


    this.pixel3.green(40);
    assertEquals(40, this.pixel3.getGreen());

  }

  @Test
  public void Blue() {
    this.pixel1.blue(100);
    assertEquals(100, this.pixel1.getBlue());


    this.pixel2.blue(200);
    assertEquals(200, this.pixel2.getBlue());


    this.pixel3.blue(240);
    assertEquals(240, this.pixel3.getBlue());

  }

  @Test
  public void maxValue() {
    assertEquals(0, this.pixel1.maxValue());
    assertEquals(239, this.pixel2.maxValue());
    assertEquals(255, this.pixel5.maxValue());
  }

  @Test
  public void intensity() {
    assertEquals(0, this.pixel1.intensity());
    assertEquals(100, this.pixel2.intensity());
    assertEquals(255, this.pixel5.intensity());
  }

  @Test
  public void luma() {
    assertEquals(0, this.pixel1.luma());
    assertEquals(75, this.pixel2.luma());
    assertEquals(254, this.pixel5.luma());
  }

  @Test
  public void testToString() {
    assertEquals("r: 0,g: 0,b: 0", this.pixel1.toString());
    assertEquals("r: 239,g: 31,b: 31", this.pixel2.toString());
    assertEquals("r: 255,g: 255,b: 255", this.pixel5.toString());
  }

}