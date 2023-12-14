#include <Arduino.h>
#include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 32

#define OLED_RESET -1
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);

#define TEMT6000_PIN A6

#define ADC_RESOLUTION 12
#define ADC_MAX_VALUE ((1 << ADC_RESOLUTION) - 1)

void setup()
{
  Serial.begin(115200);

  if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C))
  {
    Serial.println(F("SSD1306 allocation failed"));
    for (;;)
      ;
  }

  display.display();

  display.clearDisplay();

  display.setTextColor(SSD1306_WHITE);
  display.setCursor(0, 0);
  display.println("Bombastic");

  display.display();

  Serial.println("Hello World!");

  pinMode(TEMT6000_PIN, INPUT);

  analogReadResolution(ADC_RESOLUTION);
}

void loop()
{
  uint16_t value = analogRead(TEMT6000_PIN);

  display.clearDisplay();
  display.setCursor(0, 0);

  display.println("Bombastic");
  display.println("Light Sensor: " + String((float)value / ADC_MAX_VALUE * 100) + "%");

  display.display();

  delay(100);
}
