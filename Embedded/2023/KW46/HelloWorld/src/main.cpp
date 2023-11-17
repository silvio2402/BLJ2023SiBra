#include "Arduino.h"
#include <WiFi.h>

char ssid[] = "GuestWLANPortal";
char pass[] = "";

void setup()
{
  Serial.begin(115200);
  while (!Serial)
  {
  }

  Serial.print("Connecting to ");
  Serial.print(ssid);
  WiFi.begin(ssid);

  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println("done!");

  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());
}

void loop()
{
}
