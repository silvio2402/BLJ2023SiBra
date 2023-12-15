#ifndef CONN_H
#define CONN_H

#include <Arduino.h>
#include <WiFi.h>
#include <PubSubClient.h>

#define SSID "GuestWLANPortal"
#define PASSWORD NULL

#define MQTT_SERVER "noseryoung.ddns.net"
#define MQTT_PORT 1983
#define MQTT_ID "esp32_team1"

extern WiFiClient wifiClient;
extern PubSubClient mqttClient;

void setupWifi();

void setupMqtt();

#endif
