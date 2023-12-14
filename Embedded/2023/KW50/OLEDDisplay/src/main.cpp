#include <Arduino.h>
#include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <Adafruit_AHTX0.h>
#include <Adafruit_Sensor.h>

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 32

#define OLED_RESET -1
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);

Adafruit_AHTX0 aht;

void setup()
{
  Serial.begin(115200);

  display.display();

  if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C))
  {
    Serial.println(F("SSD1306 allocation failed"));
    for (;;)
      ;
  }

  if (!aht.begin())
  {
    Serial.println("Could not find AHT? Check wiring");
    while (1)
      ;
  }

  display.clearDisplay();

  display.setTextColor(SSD1306_WHITE);
  display.setCursor(0, 0);
  display.println("Bombastic");

  display.display();

  Serial.println("Hello World!");
}

void loop()
{
  display.clearDisplay();
  display.setCursor(0, 0);

  display.println("Bombastic");

  sensors_event_t humidity, temp;
  aht.getEvent(&humidity, &temp);

  display.println("Humidity: " + String(humidity.relative_humidity) + "%");
  display.println("Temperature: " + String(temp.temperature) + "C");

  display.display();

  delay(100);
}
