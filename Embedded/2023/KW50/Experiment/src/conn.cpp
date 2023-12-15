#include "conn.h"
#include <Arduino.h>
#include <WiFi.h>
#include <PubSubClient.h>

WiFiClient wifiClient;
PubSubClient mqttClient(wifiClient);

void setupWifi()
{
  Serial.print("Connecting to WiFi: ");
  Serial.println(SSID);

  wl_status_t status = WL_DISCONNECTED;

  while (status != WL_CONNECTED)
  {
    WiFi.begin(SSID, PASSWORD);
    status = (wl_status_t)WiFi.waitForConnectResult();

    if (status != WL_CONNECTED)
    {
      Serial.print("Failed to connect: ");
      Serial.println(status);
      Serial.println("Retrying in 3s...");
      delay(3000);
    }
  }

  Serial.println("WiFi connected");
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());
}

void setupMqtt()
{
  Serial.print("Connecting to MQTT: ");
  Serial.print(MQTT_SERVER);
  Serial.print(":");
  Serial.println(MQTT_PORT);

  mqttClient.setServer(MQTT_SERVER, MQTT_PORT);

  bool connected = false;

  while (!connected)
  {
    connected = mqttClient.connect(MQTT_ID);

    if (!connected)
    {
      Serial.print("Failed to connect: ");
      Serial.println(mqttClient.state());
      Serial.println("Retrying in 3s...");
      delay(3000);
    }
  }

  Serial.println("MQTT connected");
  Serial.print("MQTT ID: ");
  Serial.println(MQTT_ID);
}
