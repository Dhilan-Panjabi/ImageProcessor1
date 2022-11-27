package command;

import org.junit.Before;
import org.junit.Test;

import controller.command.Greyscale;
import model.Pixel;

import static org.junit.Assert.assertEquals;


/**
 * Represents the greyscale test.
 */
public class GreyscaleTest {

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
  public void maxValue1() {
    init();
    Greyscale greyScale = new Greyscale("value-component");
    assertEquals(new Pixel(0, 0, 0).toString(),
            greyScale.maxValue(pixel1).toString());
    assertEquals(0, this.pixel1.maxValue());
  }

  @Test
  public void maxValue2() {
    init();
    Greyscale greyScale = new Greyscale("value-component");
    assertEquals(new Pixel(239, 239, 239).toString(),
            greyScale.maxValue(pixel2).toString());
    assertEquals(239, this.pixel2.maxValue());
  }


  @Test
  public void maxValue3() {
    init();
    Greyscale greyScale = new Greyscale("value-component");
    assertEquals(new Pixel(239, 239, 239).toString(),
            greyScale.maxValue(pixel3).toString());
    assertEquals(239, this.pixel3.maxValue());
  }

  @Test
  public void maxValue4() {
    init();
    Greyscale greyScale = new Greyscale("value-component");
    assertEquals(new Pixel(239, 239, 239).toString(),
            greyScale.maxValue(pixel4).toString());
    assertEquals(239, this.pixel4.maxValue());
  }

  @Test
  public void maxValue5() {
    init();
    Greyscale greyScale = new Greyscale("value-component");
    assertEquals(new Pixel(255, 255, 255).toString(),
            greyScale.maxValue(pixel5).toString());
    assertEquals(255, this.pixel5.maxValue());
  }

  @Test
  public void blueScale1() {
    init();
    Greyscale blueScale = new Greyscale("blue-component");
    blueScale.blueScale(pixel1);
    assertEquals(new Pixel(0, 0, 0).toString(), pixel1.toString());
  }

  @Test
  public void blueScale2() {
    init();
    Greyscale blueScale = new Greyscale("blue-component");
    blueScale.blueScale(pixel2);
    assertEquals(new Pixel(31, 31, 31).toString(), pixel2.toString());
  }

  @Test
  public void blueScale3() {
    init();
    Greyscale blueScale = new Greyscale("blue-component");
    blueScale.blueScale(pixel3);
    assertEquals(new Pixel(239, 239, 239).toString(), pixel3.toString());
  }

  @Test
  public void blueScale4() {
    init();
    Greyscale blueScale = new Greyscale("blue-component");
    blueScale.blueScale(pixel4);
    assertEquals(new Pixel(86, 86, 86).toString(), pixel4.toString());
  }

  @Test
  public void blueScale5() {
    init();
    Greyscale blueScale = new Greyscale("blue-component");
    blueScale.blueScale(pixel5);
    assertEquals(new Pixel(255, 255, 255).toString(), pixel5.toString());
  }

  @Test
  public void greenScale1() {
    init();
    Greyscale greenScale = new Greyscale("green-component");
    greenScale.greenScale(pixel1);
    assertEquals(new Pixel(0, 0, 0).toString(), pixel1.toString());
  }

  @Test
  public void greenScale2() {
    init();
    Greyscale greenScale = new Greyscale("green-component");
    greenScale.greenScale(pixel2);
    assertEquals(new Pixel(31, 31, 31).toString(), pixel2.toString());
  }

  @Test
  public void greenScale3() {
    init();
    Greyscale greenScale = new Greyscale("green-component");
    greenScale.greenScale(pixel3);
    assertEquals(new Pixel(44, 44, 44).toString(), pixel3.toString());
  }

  @Test
  public void greenScale4() {
    init();
    Greyscale greenScale = new Greyscale("green-component");
    greenScale.greenScale(pixel4);
    assertEquals(new Pixel(239, 239, 239).toString(), pixel4.toString());
  }

  @Test
  public void greenScale5() {
    init();
    Greyscale greenScale = new Greyscale("green-component");
    greenScale.greenScale(pixel5);
    assertEquals(new Pixel(255, 255, 255).toString(), pixel5.toString());
  }

  @Test
  public void redScale1() {
    init();
    Greyscale redScale = new Greyscale("red-component");
    redScale.redScale(pixel1);
    assertEquals(new Pixel(0, 0, 0).toString(), pixel1.toString());
  }

  @Test
  public void redScale2() {
    init();
    Greyscale redScale = new Greyscale("red-component");
    redScale.redScale(pixel2);
    assertEquals(new Pixel(239, 239, 239).toString(), pixel2.toString());
  }

  @Test
  public void redScale3() {
    init();
    Greyscale redScale = new Greyscale("red-component");
    redScale.redScale(pixel3);
    assertEquals(new Pixel(31, 31, 31).toString(), pixel3.toString());
  }

  @Test
  public void redScale4() {
    init();
    Greyscale redScale = new Greyscale("red-component");
    redScale.redScale(pixel4);
    assertEquals(new Pixel(31, 31, 31).toString(), pixel4.toString());
  }

  @Test
  public void redScale5() {
    init();
    Greyscale redScale = new Greyscale("red-component");
    redScale.redScale(pixel5);
    assertEquals(new Pixel(255, 255, 255).toString(), pixel5.toString());
  }


  @Test
  public void intensity() {
    init();
    Greyscale intensity = new Greyscale("intensity-component");
    intensity.intensity(pixel1);
    assertEquals(new Pixel(0, 0, 0).toString(), pixel1.toString());
    intensity.intensity(pixel2);
    assertEquals(new Pixel(100, 100, 100).toString(), pixel2.toString());
    intensity.intensity(pixel3);
    assertEquals(new Pixel(104, 104, 104).toString(), pixel3.toString());
    intensity.intensity(pixel4);
    assertEquals(new Pixel(118, 118, 118).toString(), pixel4.toString());
    intensity.intensity(pixel5);
    assertEquals(new Pixel(255, 255, 255).toString(), pixel5.toString());
  }

  @Test
  public void luma() {
    init();
    Greyscale luma = new Greyscale("luma-component");
    luma.luma(pixel1);
    assertEquals(new Pixel(0, 0, 0).toString(), pixel1.toString());
    luma.luma(pixel2);
    assertEquals(new Pixel(75, 75, 75).toString(), pixel2.toString());
    luma.luma(pixel3);
    assertEquals(new Pixel(55, 55, 55).toString(), pixel3.toString());
    luma.luma(pixel4);
    assertEquals(new Pixel(183, 183, 183).toString(), pixel4.toString());
    luma.luma(pixel5);
    assertEquals(new Pixel(254, 254, 254).toString(), pixel5.toString());
  }

  @Test
  public void testToString() {
    init();
    assertEquals("r: 0,g: 0,b: 0", pixel1.toString());
    Greyscale redGreyscale = new Greyscale("red-component");
    redGreyscale.redScale(pixel2);
    assertEquals("r: 239,g: 239,b: 239", this.pixel2.toString());
    Greyscale greenGreyscale = new Greyscale("green-component");
    greenGreyscale.greenScale(pixel3);
    assertEquals("r: 44,g: 44,b: 44", this.pixel3.toString());
    Greyscale blueGreyscale = new Greyscale("blue-component");
    blueGreyscale.blueScale(pixel4);
    assertEquals("r: 86,g: 86,b: 86", this.pixel4.toString());
    Greyscale luma = new Greyscale("luma-component");
    luma.luma(pixel5);
    assertEquals("r: 254,g: 254,b: 254", this.pixel5.toString());
  }
}