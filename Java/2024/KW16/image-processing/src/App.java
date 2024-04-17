import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class App {
    private static final Random rand = new Random();

    public static void main(String[] args) throws Exception {
        File imgFile = new File("image.png");
        final BufferedImage img = ImageIO.read(imgFile);

        final double ratio = 0.9;

        // Noise up de image
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                if (rand.nextDouble() < ratio) {
                    Color color;
                    if (rand.nextBoolean()) {
                        color = Color.BLACK;
                    } else {
                        color = Color.WHITE;
                    }

                    img.setRGB(x, y, color.getRGB());
                }
            }
        }

        ImageIO.write(img, "png", new File("noisy_image.png"));

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                if (img.getRGB(x, y) == Color.BLACK.getRGB() || img.getRGB(x, y) == Color.WHITE.getRGB()) {
                    int r = 0;
                    int g = 0;
                    int b = 0;
                    int count = 0;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            try {
                                Color c = new Color(img.getRGB(x + i, y + j));
                                if (c.getRGB() == Color.BLACK.getRGB() || c.getRGB() == Color.WHITE.getRGB()) {
                                    continue;
                                }
                                r += c.getRed();
                                g += c.getGreen();
                                b += c.getBlue();
                                count++;
                            } catch (IndexOutOfBoundsException e) {
                                continue;
                            }
                        }
                    }
                    if (count == 0) {
                        continue;
                    }
                    Color newColor = new Color(r / count, g / count, b / count);
                    img.setRGB(x, y, newColor.getRGB());
                }
            }
        }

        ImageIO.write(img, "png", new File("denoised_image.png"));
    }
}
