#include <Arduino.h>
#include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <RotaryEncoder.h>

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 32

#define OLED_RESET -1
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);

#define ENC_PIN1 35
#define ENC_PIN2 32

RotaryEncoder encoder(ENC_PIN1, ENC_PIN2, RotaryEncoder::LatchMode::TWO03);

int counter = 0;

void IRAM_ATTR updateEncoder();
void updateDisplay();

void setup()
{
  Serial.begin(115200);

  if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C))
  {
    Serial.println(F("SSD1306 allocation failed"));
    for (;;)
      ;
  }

  display.clearDisplay();

  attachInterrupt(ENC_PIN1, updateEncoder, CHANGE);
  attachInterrupt(ENC_PIN2, updateEncoder, CHANGE);
}

void loop()
{
  counter = encoder.getPosition();

  updateDisplay();
}

void IRAM_ATTR updateEncoder()
{
  encoder.tick();
}

void updateDisplay()
{
  display.clearDisplay();

  display.setTextColor(SSD1306_WHITE);
  display.setCursor(0, 0);

  display.setTextSize(2);
  display.println("Bombastic");

  display.setTextSize(2);

  String counterString = String(counter);

  for (size_t i = 0; i < 10 - counterString.length(); i++)
  {
    display.print(" ");
  }

  display.println(counterString);

  display.display();
}
