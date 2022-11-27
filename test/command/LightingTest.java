package command;

import org.junit.Before;
import org.junit.Test;

import controller.command.Lighting;
import model.Pixel;

import static org.junit.Assert.assertEquals;


/**
 * Represents the lighting test.
 */
public class LightingTest {

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
  public void testBrightenDarken() {
    Lighting brighten = new Lighting(30, "brighten");
    brighten.command(pixel1);
    assertEquals("r: 30,g: 30,b: 30", this.pixel1.toString());
    brighten.command(pixel2);
    assertEquals("r: 239,g: 61,b: 61", this.pixel2.toString());
    brighten.command(pixel3);
    assertEquals("r: 61,g: 74,b: 239", this.pixel3.toString());
    init();
    Lighting d1 = new Lighting(40, "darken");
    d1.command(pixel1);
    assertEquals("r: 0,g: 0,b: 0", this.pixel1.toString());
    d1.command(pixel2);
    assertEquals("r: 199,g: 31,b: 31", this.pixel2.toString());
    d1.command(pixel3);
    assertEquals("r: 31,g: 4,b: 199", this.pixel3.toString());
  }

  @Test
  public void testToString() {
    assertEquals("r: 0,g: 0,b: 0", this.pixel1.toString());
    Lighting b1 = new Lighting(20, "brighten");
    b1.command(pixel2);
    assertEquals("r: 239,g: 51,b: 51", this.pixel2.toString());
    Lighting d1 = new Lighting(20, "darken");
    d1.command(pixel3);
    assertEquals("r: 11,g: 24,b: 219", this.pixel3.toString());
  }

}


